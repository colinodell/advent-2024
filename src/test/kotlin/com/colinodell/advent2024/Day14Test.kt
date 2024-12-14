package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 14: Restroom Redoubt")
class Day14Test {
    private val exampleInput = inputAsListOfString("day14_example.txt")
    private val puzzleInput = inputAsListOfString("day14_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day14(exampleInput, 11, 7).solvePart1()).isEqualTo(12)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day14(puzzleInput, 101, 103).solvePart1()).isEqualTo(225648864)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day14(puzzleInput, 101, 103).solvePart2()).isEqualTo(7847)
    }
}
