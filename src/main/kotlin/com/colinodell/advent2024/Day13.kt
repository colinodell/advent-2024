package com.colinodell.advent2024

class Day13(input: String) {
    private val part2Offset = Vector2L(10000000000000L, 10000000000000L)

    private val clawMachines = input.split("\n\n").map {
        Regex("""Button A: X\+(\d+), Y\+(\d+)\nButton B: X\+(\d+), Y\+(\d+)\nPrize: X=(\d+), Y=(\d+)""")
            .matchEntire(it)!!
            .destructured
            .let { (buttonAX, buttonAY, buttonBX, buttonBY, prizeX, prizeY) ->
                ClawMachine(
                    Vector2(buttonAX.toInt(), buttonAY.toInt()),
                    Vector2(buttonBX.toInt(), buttonBY.toInt()),
                    Vector2L(prizeX.toLong(), prizeY.toLong()),
                )
            }
    }

    fun solvePart1() = clawMachines.sumOf { it.solve() }

    fun solvePart2() = clawMachines.sumOf { it.copy(prize = it.prize + part2Offset).solve() }

    private data class ClawMachine(val buttonA: Vector2, val buttonB: Vector2, val prize: Vector2L) {
        fun solve(): Long {
            val aPresses = (prize.x * buttonB.y - prize.y * buttonB.x) / (buttonA.x * buttonB.y - buttonA.y * buttonB.x)
            val bPresses = (prize.x * buttonA.y - prize.y * buttonA.x) / (buttonB.x * buttonA.y - buttonA.x * buttonB.y)

            return when {
                buttonA * aPresses + buttonB * bPresses == prize -> 3 * aPresses + bPresses
                else -> 0
            }
        }
    }
}
