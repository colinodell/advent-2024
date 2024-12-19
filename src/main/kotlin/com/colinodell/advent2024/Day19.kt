package com.colinodell.advent2024

class Day19(input: List<String>) {
    private val towels = input[0].split(", ")
    private val designs = input.drop(2)

    fun solvePart1() = designs.count { possibleArrangements(it) > 0 }

    fun solvePart2() = designs.sumOf { possibleArrangements(it) }

    private val memo = mutableMapOf<String, Long>()

    private fun possibleArrangements(design: String): Long {
        if (design.isEmpty()) {
            return 1
        }

        if (!memo.containsKey(design)) {
            memo[design] = towels.sumOf {
                when {
                    design.startsWith(it) -> possibleArrangements(design.substring(it.length))
                    else -> 0
                }
            }
        }

        return memo[design]!!
    }
}
