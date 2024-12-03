package com.colinodell.advent2024

class Day03(input: String) {
    private val instructions = Regex("""mul\((\d{1,3}),(\d{1,3})\)|do(?:n't)?\(\)""").findAll(input).toList()

    fun solvePart1() = executeInstructions(withConditionals = false).acc
    fun solvePart2() = executeInstructions(withConditionals = true).acc

    private fun executeInstructions(withConditionals: Boolean = false) =
        instructions.fold(ExecutionState()) { state, instruction ->
            when {
                instruction.value == "do()" && withConditionals -> state.copy(mulEnabled = true)
                instruction.value == "don't()" && withConditionals -> state.copy(mulEnabled = false)
                instruction.value.startsWith("mul") && state.mulEnabled -> {
                    val (a, b) = instruction.groupValues.drop(1).map(String::toInt)
                    state.copy(acc = state.acc + a * b)
                }

                else -> state
            }
        }

    private data class ExecutionState(val acc: Int = 0, val mulEnabled: Boolean = true)
}
