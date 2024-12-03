package com.colinodell.advent2024

class Day03(input: String) {
    private val instructions = Regex("""mul\((\d{1,3}),(\d{1,3})\)|do(?:n't)?\(\)""").findAll(input).toList()

    fun solvePart1() = executeInstructions(withConditionals = false)
    fun solvePart2() = executeInstructions(withConditionals = true)

    private fun executeInstructions(withConditionals: Boolean = false): Int {
        var acc = 0
        var mulEnabled = true
        for (instruction in instructions) {
            when {
                instruction.value.startsWith("mul") -> if (mulEnabled) {
                    val (a, b) = instruction.groupValues.drop(1).map(String::toInt)
                    acc += a * b
                }

                instruction.value == "do()" -> if (withConditionals) {
                    mulEnabled = true
                }

                instruction.value == "don't()" -> if (withConditionals) {
                    mulEnabled = false
                }
            }
        }
        return acc
    }
}
