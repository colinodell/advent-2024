package com.colinodell.advent2024

class Day04(input: List<String>) {
    private val wordSearch = input.toGrid()

    private val searchDirections = listOf(
        Vector2(0, 1),
        Vector2(1, 0),
        Vector2(1, 1),
        Vector2(1, -1),
        Vector2(0, -1),
        Vector2(-1, 0),
        Vector2(-1, -1),
        Vector2(-1, 1),
    )

    fun solvePart1() = wordSearch.keys.sumOf { pos ->
        searchDirections.count { dir -> wordExists("XMAS", pos, dir) }
    }

    fun solvePart2() = wordSearch.filter { it.value == 'A' }.keys.count { pos ->
        // Check diagonals for "MAS" or "SAM"
        val words = listOf(
            wordSearch.valuesBetween(pos + Vector2(-1, -1), pos + Vector2(1, 1)),
            wordSearch.valuesBetween(pos + Vector2(1, -1), pos + Vector2(-1, 1)),
        )

        words.all { it.joinToString("") in setOf("MAS", "SAM") }
    }

    private fun wordExists(word: String, start: Vector2, direction: Vector2): Boolean =
        word.indices.all { i ->
            val current = start + direction * i
            current in wordSearch && wordSearch[current] == word[i]
        }
}
