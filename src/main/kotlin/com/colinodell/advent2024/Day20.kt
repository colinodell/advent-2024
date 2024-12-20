package com.colinodell.advent2024

class Day20(input: List<String>) {
    private val grid = input.toGrid()
    private val path = getPath(
        grid,
        grid.entries.first { it.value == 'S' }.key,
        grid.entries.first { it.value == 'E' }.key,
    )

    fun solvePart1(minTimeSaved: Int) = findCheats(2).count { it.timeSaved >= minTimeSaved }

    fun solvePart2(minTimeSaved: Int) = findCheats(20).count { it.timeSaved >= minTimeSaved }

    private fun getPath(grid: Grid<Char>, start: Vector2, end: Vector2): Map<Vector2, Int> {
        val path = mutableMapOf<Vector2, Int>()
        var pos = start

        path[start] = 0

        while (pos != end) {
            // Find the next direction to move (must be in the grid and not a wall)
            val next = Direction.entries
                .map { pos + it.vector() }
                .firstOrNull { it !in path && it in grid && grid[it] != '#' }
                ?: error("No path found from $pos to $end")

            path[next] = path[pos]!! + 1
            pos = next
        }

        return path
    }

    private fun findCheats(maxLength: Int): List<Cheat> {
        val cheats = mutableListOf<Cheat>()

        path.entries.forEach { start ->
            path.entries.forEach { end ->
                if (start.key != end.key && start.value < end.value) {
                    val distance = start.key.manhattanDistanceTo(end.key)
                    if (distance in 2..maxLength) {
                        val timeSaved = end.value - start.value - distance
                        if (timeSaved > 0) {
                            cheats.add(Cheat(start.key, end.key, timeSaved))
                        }
                    }
                }
            }
        }

        return cheats
    }

    private data class Cheat(val start: Vector2, val end: Vector2, val timeSaved: Int)
}
