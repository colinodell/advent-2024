package com.colinodell.advent2024

class Day24(input: List<String>) {
    private val resolved = input
        .takeWhile { it != "" }
        .map { it.split(": ") }
        .associate { it[0] to (it[1] == "1") }

    private val gates = input
        .dropWhile { it != "" }
        .drop(1)
        .map { line ->
            line.split(" ").let { Gate(it[0], it[2], Operation.valueOf(it[1]), it[4]) }
        }

    fun solvePart1() = run(resolved, gates)

    // Based on https://github.com/eagely/adventofcode/blob/470c14b97fc03773872db32ca6b76cd3c52df548/src/main/kotlin/solutions/y2024/Day24.kt#L18-L33
    fun solvePart2(): String {
        // All z-bits should normally be XOR gates (except for the final carry)
        val badZOutputs = gates.filter { gate ->
            gate.output.first() == 'z' && gate.output != "z45" && gate.operation != Operation.XOR
        }

        // All XOR gates should either output to a z wire or be an internal carry
        val badXorGates = gates.filter { gate ->
            gate.operation == Operation.XOR && gate.inputA.first() !in "xy" && gate.inputB.first() !in "xy" && gate.output.first() != 'z'
        }

        for (xorGate in badXorGates) {
            val targetOutput = firstZGateThatConsumes(xorGate.output, gates)
            val gateWithZOutput = badZOutputs.first { gate -> gate.output == targetOutput }

            // Perform the swap
            val temp = xorGate.output
            xorGate.output = gateWithZOutput.output
            gateWithZOutput.output = temp
        }

        // Run the circuit to find the bad carry
        val badCarry = (wiresToLong(resolved, 'x') + wiresToLong(resolved, 'y') xor run(resolved, gates))
            .countTrailingZeroBits()
            .toString()

        return (badZOutputs + badXorGates + gates.filter { it.inputA.endsWith(badCarry) && it.inputB.endsWith(badCarry) })
            .map { it.output }
            .sorted()
            .joinToString(",")
    }

    private fun run(wires: Map<String, Boolean>, gates: Collection<Gate>): Long {
        val wires = wires.toMutableMap()
        val gates = gates.associateBy { it.output }

        fun evaluate(wire: String): Boolean = wires.getOrPut(wire) {
            with(gates[wire]!!) {
                operation.exec(evaluate(inputA), evaluate(inputB))
            }
        }

        gates.keys.filter { it.startsWith("z") }.map { evaluate(it) }

        return wiresToLong(wires, 'z')
    }

    private fun wiresToLong(wires: Map<String, Boolean>, c: Char) = wires
        .filterKeys { it.startsWith(c) }
        .toList()
        .sortedBy { it.first }
        .mapIndexed { index, (_, value) -> if (value) 1L shl index else 0L }
        .reduce(Long::or)

    private fun firstZGateThatConsumes(wire: String, gates: Collection<Gate>): String? {
        val consumers = gates.filter { g -> g.inputA == wire || g.inputB == wire }

        consumers.find { it.output.startsWith('z') }?.let { consumerGate ->
            val gateIndex = consumerGate.output.drop(1).toIntOrNull() ?: return consumerGate.output
            return "z" + (gateIndex - 1).toString().padStart(2, '0')
        }

        return consumers.firstNotNullOfOrNull { firstZGateThatConsumes(it.output, gates) }
    }

    private enum class Operation(val exec: (Boolean, Boolean) -> Boolean) {
        AND(Boolean::and),
        OR(Boolean::or),
        XOR(Boolean::xor),
    }

    private data class Gate(val inputA: String, val inputB: String, val operation: Operation, var output: String)
}
