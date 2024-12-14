package com.colinodell.advent2024

class Day14(input: List<String>, private val width: Int, private val height: Int) {
    private val robots = input.map { Robot.fromString(it) }

    private val quadrants = listOf(
        Region(Vector2(0, 0), Vector2(width / 2 - 1, height / 2 - 1)),
        Region(Vector2(width / 2 + 1, 0), Vector2(width - 1, height / 2 - 1)),
        Region(Vector2(0, height / 2 + 1), Vector2(width / 2 - 1, height - 1)),
        Region(Vector2(width / 2 + 1, height / 2 + 1), Vector2(width - 1, height - 1)),
    )

    fun solvePart1() = robotsAfter(100).let { robots ->
        quadrants.fold(1) { acc, quad -> acc * robots.count { pos -> pos in quad } }
    }

    fun solvePart2() = generateSequence(0) { it + 1 }
        .indexOfFirst { n -> allRobotsInUniquePositions(robotsAfter(n)) }

    private data class Robot(var pos: Vector2, val velocity: Vector2) {
        companion object {
            fun fromString(input: String) = Regex("""p=(\d+),(\d+) v=(-?\d+),(-?\d+)""")
                .matchEntire(input)!!
                .destructured
                .let { (px, py, vx, vy) ->
                    Robot(Vector2(px.toInt(), py.toInt()), Vector2(vx.toInt(), vy.toInt()))
                }
        }
    }

    private fun robotsAfter(n: Int) = robots.map { teleport(it.pos + (it.velocity * n)) }

    private fun teleport(pos: Vector2) = Vector2(
        Math.floorMod(pos.x, width),
        Math.floorMod(pos.y, height),
    )

    private fun allRobotsInUniquePositions(robots: List<Vector2>) = robots.toSet().size == robots.size
}
