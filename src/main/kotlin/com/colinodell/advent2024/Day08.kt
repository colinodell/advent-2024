package com.colinodell.advent2024

class Day08(input: List<String>) {
    private val grid = input.toGrid()
    private val region = grid.region()
    private val antennaPairs = grid
        // Find all antenna locations
        .filter { it.value != '.' }
        .keys
        // Group by frequency
        .groupBy { grid[it]!! }
        // Generate antenna pairs
        .values
        .flatMap { it.permutationPairs() }

    fun solvePart1() = antennaPairs
        .flatMap { (a, b) ->
            listOf(
                a - (b - a),
                b + (b - a),
            ).filter { it in region }
        }
        .toSet()
        .size

    fun solvePart2() = antennaPairs
        .flatMap { (a, b) ->
            generateSequence(a) { it - (b - a) }.takeWhile { it in region } +
                generateSequence(b) { it + (b - a) }.takeWhile { it in region }
        }
        .toSet()
        .size
}
