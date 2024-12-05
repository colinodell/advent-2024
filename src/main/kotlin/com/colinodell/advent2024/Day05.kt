package com.colinodell.advent2024

class Day05(input: List<String>) {
    private val orderings = input
        .filter { it.contains("|") }
        .map { it.split("|").map(String::toInt) }
        .groupBy({ it[0] }, { it[1] })

    private val updates = input
        .filter { it.contains(",") }
        .map { it.split(",").map(String::toInt) }

    fun solvePart1() = updates
        .filter { update -> update == correctOrder(update) }
        .sumOf { it[it.size / 2] }

    fun solvePart2() = updates
        .mapNotNull { update -> correctOrder(update).takeIf { it != update } }
        .sumOf { it[it.size / 2] }

    private fun correctOrder(update: List<Int>): List<Int> {
        // Let's remove all irrelevant orderings for efficiency and easier logic
        val dependencies = orderings
            .filterKeys { it in update }
            .mapValues { (_, v) -> v.filter { it in update }.toSet() }

        // We'll now perform a topological sort using Kahn's algorithm
        // Step 1: Compute in-degrees for each node
        // (This is basically the number of dependencies each node has)
        val inDegrees = update.associateWith { 0 }.toMutableMap()
        for ((_, v) in dependencies) {
            for (page in v) {
                inDegrees[page] = inDegrees[page]!! + 1
            }
        }

        // Step 2: Start with nodes that have no dependencies
        val queue = ArrayDeque(update.filter { inDegrees[it] == 0 })

        // Step 3: Process the queue
        val sorted = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            val page = queue.removeFirst()
            sorted.add(page)

            dependencies[page]?.forEach { dep ->
                inDegrees[dep] = inDegrees[dep]!! - 1
                if (inDegrees[dep] == 0) {
                    queue.add(dep)
                }
            }
        }

        // This should never happen for our inputs
        check(sorted.size == update.size) { "Cycle detected!" }

        return sorted
    }
}
