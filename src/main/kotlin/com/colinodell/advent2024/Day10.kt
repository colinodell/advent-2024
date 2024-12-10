package com.colinodell.advent2024

class Day10(input: List<String>) {
    private val grid = input.toGrid(ignore = '.') { it.digitToInt() }
    private val trailheads = grid.keys.filter { grid[it] == 0 }

    fun solvePart1() = trailheads.sumOf { calculateScore(it) }

    fun solvePart2() = trailheads.sumOf { calculateRating(it) }

    // The score is the number of distinct `9` positions we can reach from the given trailhead
    private fun calculateScore(trailhead: Vector2): Int {
        val visited = mutableSetOf(trailhead)
        val queue = mutableListOf(trailhead)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            val currentValue = grid[current]!!

            // Find the next position to visit
            current.neighbors().filter { it !in visited && grid[it] == currentValue + 1 }.forEach {
                visited.add(it)
                queue.add(it)
            }
        }

        return visited.count { grid[it] == 9 }
    }

    // The rating is the number of distinct paths we can take from the given trailhead to a `9` position
    private fun calculateRating(trailhead: Vector2): Int {
        var paths = 0
        val queue = mutableListOf(listOf(trailhead))

        while (queue.isNotEmpty()) {
            val currentPath = queue.removeFirst()
            val lastPosition = currentPath.last()
            val lastValue = grid[lastPosition]!!

            // Find the next position to visit
            lastPosition.neighbors().filter { it !in currentPath && grid[it] == lastValue + 1 }.forEach {
                if (grid[it] == 9) {
                    paths++
                } else {
                    queue.add(currentPath + it)
                }
            }
        }

        return paths
    }
}
