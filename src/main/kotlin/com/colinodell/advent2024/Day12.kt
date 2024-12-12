package com.colinodell.advent2024

class Day12(input: List<String>) {
    private val grid = input.toGrid()
    private val plots = splitIntoContiguousPlots()

    fun solvePart1() = plots.sumOf { plants ->
        plants.size * plants.sumOf { 4 - it.neighbors().filter { it in plants }.size }
    }

    fun solvePart2() = plots.sumOf { plants ->
        plants.size * corners(plants)
    }

    private fun splitIntoContiguousPlots(): List<Set<Vector2>> {
        val plots = mutableListOf<Set<Vector2>>()
        val ungrouped = grid.keys.toMutableSet()

        while (ungrouped.isNotEmpty()) {
            val plot = mutableSetOf<Vector2>()
            val queue = mutableListOf(ungrouped.first())

            while (queue.isNotEmpty()) {
                val current = queue.removeFirst()
                if (current in plot) continue

                plot.add(current)
                ungrouped.remove(current)

                current.neighbors().filter { it in ungrouped && grid[it] == grid[current] }.forEach {
                    queue.add(it)
                }
            }

            plots.add(plot)
        }

        return plots
    }

    private val perpendicularDirections = setOf(
        Pair(Direction.NORTH, Direction.EAST),
        Pair(Direction.EAST, Direction.SOUTH),
        Pair(Direction.SOUTH, Direction.WEST),
        Pair(Direction.WEST, Direction.NORTH),
    )

    private fun corners(plot: Set<Vector2>) = plot.sumOf { plantPos ->
        val plant = grid[plantPos]

        perpendicularDirections.count { (dir1, dir2) ->
            // Variables are named as if we're looking at a 45-degree angle between the two perpendicular directions
            val left = grid[plantPos + dir1.vector()]
            val right = grid[plantPos + dir2.vector()]
            val across = grid[plantPos + dir1.vector() + dir2.vector()]

            // There are two types of corners:
            //
            //   1. An "outside" (convex) corner, where the two adjacent plants are completely different:
            //
            //     ...
            //     XX.  <-- imagine we're at the center looking towards the north-east
            //     XX.
            //
            //   2. An "inside" (concave) corner that bends inward around some different plant:
            //
            //     XX.
            //     XXX  <-- imagine we're at the center looking towards the north-east
            //     XXX
            //
            (left != plant && right != plant) || (across != plant && left == plant && right == plant)
        }
    }
}
