package com.colinodell.advent2024

class Day15(input: List<String>) {
    private val grid = input.takeWhile { it.isNotEmpty() }.toGrid(ignore = '.')

    private val instructions = input
        .dropWhile { it.startsWith("#") || it.isEmpty() }
        .flatMap { it.map { Direction.from(it) } }

    fun solvePart1() = simulate(grid)
        .filterValues { it == 'O' }
        .entries
        .sumOf { it.key.x + it.key.y * 100 }

    fun solvePart2() = simulate(embiggen(grid))
        .filterValues { it == '[' }
        .entries
        .sumOf { it.key.x + it.key.y * 100 }

    private fun simulate(grid: Grid<Char>): Grid<Char> {
        val grid = grid.toMutableMap()
        var pos = grid.entries.first { it.value == '@' }.key

        for (instruction in instructions) {
            val moves = mutableMapOf<Vector2, Boolean>()
            if (canMove(grid, pos, instruction, moves)) {
                moves.keys.forEach { src ->
                    grid[src + instruction.vector()] = grid.remove(src)!!
                }
                pos += instruction.vector()
            }
        }

        return grid
    }

    // Recursively determine if we can move in the given direction
    // If so, the `moves` map will be updated with all positions that can be moved
    private fun canMove(
        grid: Map<Vector2, Char>,
        pos: Vector2,
        dir: Direction,
        moves: MutableMap<Vector2, Boolean>,
    ): Boolean {
        return moves.getOrPut(pos) {
            val next = pos + dir.vector()
            when (grid[next]) {
                null -> true
                '#' -> false
                'O' -> canMove(grid, next, dir, moves)
                '[' -> when (dir) {
                    Direction.WEST -> canMove(grid, next, dir, moves)
                    else -> canMove(grid, next, dir, moves) &&
                        canMove(grid, next + Direction.EAST.vector(), dir, moves)
                }

                ']' -> when (dir) {
                    Direction.EAST -> canMove(grid, next, dir, moves)
                    else -> canMove(grid, next, dir, moves) &&
                        canMove(grid, next + Direction.WEST.vector(), dir, moves)
                }

                else -> error("Unexpected character: ${grid[next]}")
            }
        }
    }

    private fun embiggen(grid: Grid<Char>) = grid.flatMap { (pos, value) ->
        val left = pos.copy(x = pos.x * 2)
        val right = pos.copy(x = pos.x * 2 + 1)
        when (value) {
            '#' -> listOf(left to '#', right to '#')
            '@' -> listOf(left to '@')
            'O' -> listOf(left to '[', right to ']')
            else -> emptyList()
        }
    }.toMap().toMutableMap()
}
