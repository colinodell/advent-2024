package com.colinodell.advent2024

class Day20(input: List<String>) {
    private val grid = input.toGrid()
    private val start = grid.entries.first { it.value == 'S' }.key
    private val end = grid.entries.first { it.value == 'E' }.key
    private val path = getPath(grid, start, end)

    fun solvePart1(minTimeSaved: Int) = findCheats(2, minTimeSaved)
    fun solvePart2(minTimeSaved: Int) = findCheats(20, minTimeSaved)

    private fun getPath(grid: Grid<Char>, start: Vector2, end: Vector2): Map<Vector2, Int> {
        val path = mutableMapOf(start to 0)
        var pos = start

        while (pos != end) {
            val next = pos.neighbors().first { it !in path && it in grid && grid[it] != '#' }
            path[next] = path.getValue(pos) + 1
            pos = next
        }

        return path
    }

    private fun findCheats(maxLength: Int, minTimeSaved: Int) =
        path.entries.sumOf { (startPos, startDist) ->
            path.entries.count { (endPos, endDist) ->
                val distance = startPos.manhattanDistanceTo(endPos)
                startPos != endPos &&
                    startDist < endDist &&
                    distance in 2..maxLength &&
                    (endDist - startDist - distance) >= minTimeSaved
            }
        }
}
