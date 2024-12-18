package com.colinodell.advent2024

class Day17(input: List<String>) {
    private val regA = input[0].substringAfter(": ").toLong()
    private val regB = input[1].substringAfter(": ").toLong()
    private val regC = input[2].substringAfter(": ").toLong()

    private val program: List<Int> = input[4].substringAfter(": ").split(",").map { it.toInt() }

    fun solvePart1() = Computer(regA, regB, regC)
        .run(program)
        .joinToString(",")

    // Some observations about the program and instruction set:
    //   - The program seems to work by:
    //     - Mucking around with A, B, and C
    //     - Outputting some value
    //     - Shifting A right by 3 bits and repeating
    //   - A always decreases over time
    //   - The last 3 bits of A, B, and C influence the last 3 bits of the output
    //     - The 3 bits before that influence the 3 bits before the output; etc.
    //
    // Given this, we should be able to reverse-engineer the answer by working backwards, 3 bits at a time.
    fun solvePart2(): Long {
        var candidates = listOf(0L)

        // Work backwards, one output at a time
        for (length in 1..program.size) {
            val desiredOutput = program.takeLast(length)

            val newCandidates = mutableListOf<Long>()
            for (candidate in candidates) {
                // Append each possible 3-bit value to the candidate
                for (offset in 0..7) {
                    val newA = (candidate shl 3) or offset.toLong()

                    // Does this candidate produce the desired output?
                    if (Computer(newA, regB, regC).run(program) == desiredOutput) {
                        newCandidates.add(newA)
                    }
                }
            }

            candidates = newCandidates
        }

        return candidates.minOrNull() ?: error("No solution found")
    }

    private class Computer(private var A: Long, private var B: Long, private var C: Long) {
        enum class Instruction { ADV, BXL, BST, JNZ, BXC, OUT, BDV, CDV }

        fun run(program: List<Int>): List<Int> {
            val output = mutableListOf<Int>()
            var ip = 0

            while (ip < program.size) {
                val opcode = Instruction.entries[program[ip++]]
                val operand = program[ip++]

                when (opcode) {
                    Instruction.ADV -> A = A / (1 shl combo(operand).toInt())
                    Instruction.BDV -> B = A / (1 shl combo(operand).toInt())
                    Instruction.CDV -> C = A / (1 shl combo(operand).toInt())
                    Instruction.BST -> B = combo(operand) % 8
                    Instruction.BXC -> B = B xor C
                    Instruction.BXL -> B = B xor operand.toLong()
                    Instruction.JNZ -> if (A != 0L) ip = combo(operand).toInt()
                    Instruction.OUT -> output.add((combo(operand) % 8).toInt())
                }
            }

            return output
        }

        private fun combo(operand: Int): Long = when (operand) {
            4 -> A
            5 -> B
            6 -> C
            else -> operand.toLong()
        }
    }
}
