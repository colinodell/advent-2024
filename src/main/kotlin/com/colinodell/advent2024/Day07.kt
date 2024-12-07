package com.colinodell.advent2024

class Day07(input: List<String>) {
    private val equations = input.associate { line ->
        val (target, numbers) = line.split(": ")
        target.toLong() to numbers.split(" ").map(String::toLong)
    }

    fun solvePart1() = solve(allowConcat = false)
    fun solvePart2() = solve(allowConcat = true)

    private fun solve(allowConcat: Boolean) = equations
        .entries
        .filter { (target, numbers) -> target in possibleValues(numbers, allowConcat) }
        .sumOf { it.key }

    private fun possibleValues(numbers: List<Long>, allowConcat: Boolean) = numbers.fold(listOf(0L)) { acc, number ->
        acc.flatMap {
            listOfNotNull(
                it + number,
                it * number,
                if (allowConcat) (it.toString() + number.toString()).toLong() else null,
            )
        }
    }
}
