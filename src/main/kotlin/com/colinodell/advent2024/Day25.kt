package com.colinodell.advent2024

class Day25(input: String) {
    private val locks = input.split("\n\n").filter { it.startsWith("#####") }.map { heights(it.lines()) }
    private val keys = input.split("\n\n").filter { it.endsWith("#####") }.map { heights(it.lines()) }

    fun solvePart1() = locks.sumOf { lock ->
        keys.count { key ->
            key.zip(lock).all { (keyHeight, lockHeight) -> keyHeight <= 5 - lockHeight }
        }
    }

    private fun heights(input: List<String>) =
        input.first().indices.map { index ->
            input.count { it[index] == '#' } - 1
        }
}
