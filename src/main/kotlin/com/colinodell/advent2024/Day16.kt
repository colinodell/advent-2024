package com.colinodell.advent2024

class Day16(input: List<String>) {
    private val grid = input.toGrid()

    private val start = grid.entries.first { it.value == 'S' }.key
    private val end = grid.entries.first { it.value == 'E' }.key

    private val bestPath = findBestPath(listOf(State(start, Direction.EAST)), end)

    fun solvePart1() = bestPath.score()

    fun solvePart2() = findBestPath(Direction.entries.map { State(end, it) }, start)
        .let { reversed ->
            val forwardCosts = bestPath.costs()
            val backwardCosts = reversed.costs()

            grid.count { (pos, ch) ->
                ch != '#' && Direction.entries.any { dir ->
                    val forwardC = forwardCosts[State(pos, dir)] ?: 0
                    val backwardC = backwardCosts[State(pos, dir.opposite())] ?: 0

                    forwardC + backwardC == bestPath.score()
                }
            }
        }

    private fun findBestPath(starts: Iterable<State>, endPos: Vector2) = aStar(
        starts = starts,
        reachedEnd = { it.pos == endPos },
        nextStates = { current ->
            val next = mutableSetOf(
                current.copy(dir = current.dir.turnLeft()),
                current.copy(dir = current.dir.turnRight()),
            )

            val forward = current.pos + current.dir.vector()
            if (grid[forward] != '#') {
                next += State(pos = forward, dir = current.dir)
            }

            next
        },
        cost = { prev, next -> if (prev.dir == next.dir) 1 else 1000 },
        heuristic = { it.pos.manhattanDistanceTo(end) },
    )

    private data class State(val pos: Vector2, val dir: Direction)
}
