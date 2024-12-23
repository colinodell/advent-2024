package com.colinodell.advent2024

class Day23(input: List<String>) {
    private val connections = input.fold(
        mutableMapOf<String, Set<String>>().withDefault { emptySet() },
        { map, line ->
            val (a, b) = line.split("-")
            map[a] = map.getValue(a) + b
            map[b] = map.getValue(b) + a
            map
        },
    )

    fun solvePart1() = cliques(connections, limit = 3)
        .filter { it.size == 3 }
        .count {
            it.any { it.startsWith('t') }
        }

    fun solvePart2() = cliques(connections)
        .maxBy { it.size }
        .joinToString(",")

    private fun cliques(connections: Map<String, Set<String>>, limit: Int = Int.MAX_VALUE): Set<List<String>> =
        buildSet {
            val sortedNodes = connections.keys.sorted()

            // Recursively build partial cliques, extending them one node at a time
            fun backtrack(currentClique: List<String>, startIndex: Int) {
                if (currentClique.isNotEmpty()) add(currentClique)
                if (currentClique.size == limit) return

                for (i in startIndex until sortedNodes.size) {
                    val candidate = sortedNodes[i]
                    if (currentClique.all { candidate in connections[it].orEmpty() }) {
                        backtrack(currentClique + candidate, i + 1)
                    }
                }
            }

            backtrack(emptyList(), 0)
        }
}
