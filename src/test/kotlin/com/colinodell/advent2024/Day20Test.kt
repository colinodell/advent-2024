package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 20: Race Condition")
class Day20Test {
    private val exampleInput = inputAsListOfString("day20_example.txt")
    private val puzzleInput = inputAsListOfString("day20_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day20(exampleInput).solvePart1(1)).isEqualTo(14 + 14 + 2 + 4 + 2 + 3 + 1 + 1 + 1 + 1 + 1)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day20(puzzleInput).solvePart1(100)).isEqualTo(1384)
    }

    @Test
    fun `Part 2 - Example`() {
        assertThat(Day20(exampleInput).solvePart2(50)).isEqualTo(32 + 31 + 29 + 39 + 25 + 23 + 20 + 19 + 12 + 14 + 12 + 22 + 4 + 3)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day20(puzzleInput).solvePart2(100)).isEqualTo(1008542)
    }
}
