package com.colinodell.advent2024

class Day05(input: List<String>) {
    private val orderings = input
        .filter { it.contains("|") }
        .map { it.split("|").map(String::toInt) }
        .groupBy({ it[0] }, { it[1] })

    private val updates = input
        .filter { it.contains(",") }
        .map { it.split(",").map(String::toInt) }

    fun solvePart1() = updates.filter { inCorrectOrder(it) }.sumOf { it[it.size / 2] }

    private fun inCorrectOrder(update: List<Int>): Boolean {
        val relevantOrderings = orderings
            .filterKeys { it in update }
            .mapValues { (_, v) -> v.filter { it in update }.toSet() }

        val seen = mutableSetOf<Int>()
        for (page in update) {
            if (relevantOrderings.any { (k, v) -> k !in seen && page in v }) {
                return false
            }

            seen.add(page)
        }
        return true
    }
}
