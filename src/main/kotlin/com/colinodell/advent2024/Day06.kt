package com.colinodell.advent2024

class Day06(input: List<String>) {
    private val grid = input.toGrid(ignore = '.')
    private val mappedArea = grid.region()
    private val startPos = grid.entries.first { it.value == '^' }.key

    // Both parts need to know the original path, so we'll calculate it once and store it here
    private val guardPath = navigate(grid).visited

    fun solvePart1() = guardPath.size

    fun solvePart2() = guardPath
        .filter { it != startPos }
        .asSequence() // So that .map() passes results one-by-one instead of all at once
        .map { grid.toMutableMap().apply { this[it] = '#' } }
        .count { navigate(it).loopDetected }

    private fun navigate(grid: Grid<Char>): Result {
        val visited = mutableSetOf<State>()
        var state = State(startPos, Direction.NORTH)

        while (mappedArea.contains(state.pos) && state !in visited) {
            visited.add(state)

            // Are we about to hit an obstacle? If so, turn right.
            while (grid[state.next().pos] == '#') {
                state = state.copy(dir = state.dir.turnRight())
            }

            state = state.next()
        }

        return Result(visited.map { it.pos }.toSet(), state in visited)
    }

    private data class State(val pos: Vector2, val dir: Direction) {
        fun next() = State(pos + dir.vector(), dir)
    }

    private data class Result(val visited: Set<Vector2>, val loopDetected: Boolean)
}
