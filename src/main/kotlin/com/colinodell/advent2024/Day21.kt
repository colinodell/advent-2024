package com.colinodell.advent2024

class Day21(private val input: List<String>) {
    private val numericKeypad = keypad(
        "789",
        "456",
        "123",
        " 0A",
    )
    private val directionalKeypad = keypad(
        " ^A",
        "<v>",
    )

    fun solvePart1() = solve(2)
    fun solvePart2() = solve(25)

    private fun solve(directionalKeypads: Int) =
        input.sumOf { it.dropLast(1).toInt() * shortestSequence(it, 0, directionalKeypads) }

    private val cache = mutableMapOf<Triple<String, Int, Int>, Long>()

    private fun shortestSequence(seq: String, depth: Int, limit: Int): Long {
        if (seq.isEmpty()) return 0L

        return cache.getOrPut(Triple(seq, depth, limit)) {
            val keypad = if (depth == 0) numericKeypad else directionalKeypad

            seq.fold(keypad['A']!! to 0L) { (currentPos, acc), nextChar ->
                val nextPos = keypad[nextChar]!!

                val possiblePaths = (nextPos - currentPos)
                    // Convert the difference between the two positions into a list of directions
                    .asDirections()
                    .toList()
                    // Generate all possible paths
                    .permutations()
                    // Make sure none deviate into a gap
                    .filter { path -> currentPos.follow(path).all { it in keypad.values } }
                    // Convert back into a string, adding the final "A"
                    .map { it.joinToString("") + "A" }
                    // No paths? Just press "A"
                    .ifEmpty { listOf("A") }

                val bestPath = possiblePaths.minOf { it.length }.toLong()
                if (depth == limit) return@fold nextPos to (acc + bestPath)

                val bestSubPath = possiblePaths.minOfOrNull { shortestSequence(it, depth + 1, limit) }
                nextPos to acc + (bestSubPath ?: bestPath)
            }.second
        }
    }

    private fun keypad(vararg keys: String): Map<Char, Vector2> =
        keys.flatMapIndexed { y, row ->
            row.mapIndexedNotNull { x, ch ->
                if (ch != ' ') ch to Vector2(x, y) else null
            }
        }.toMap()
}
