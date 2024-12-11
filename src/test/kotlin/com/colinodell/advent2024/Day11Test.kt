package com.colinodell.advent2024

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 11: Plutonian Pebbles")
class Day11Test {
    private val exampleInput = "125 17"
    private val puzzleInput = "2 77706 5847 9258441 0 741 883933 12"

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day11(exampleInput).solvePart1()).isEqualTo(55312)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day11(puzzleInput).solvePart1()).isEqualTo(190865)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day11(puzzleInput).solvePart2()).isEqualTo(225404711855335)
    }
}
