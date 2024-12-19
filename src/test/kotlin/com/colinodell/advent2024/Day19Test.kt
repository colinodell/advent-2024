package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 19: Linen Layout")
class Day19Test {
    private val exampleInput = inputAsListOfString("day19_example.txt")
    private val puzzleInput = inputAsListOfString("day19_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day19(exampleInput).solvePart1()).isEqualTo(6)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day19(puzzleInput).solvePart1()).isEqualTo(283)
    }

    @Test
    fun `Part 2 - Example`() {
        assertThat(Day19(exampleInput).solvePart2()).isEqualTo(16)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day19(puzzleInput).solvePart2()).isEqualTo(615388132411142L)
    }
}
