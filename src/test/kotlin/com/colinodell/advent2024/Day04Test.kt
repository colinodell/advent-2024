package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 4: Ceres Search")
class Day04Test {
    private val exampleInput = inputAsListOfString("day04_example.txt")
    private val puzzleInput = inputAsListOfString("day04_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day04(exampleInput).solvePart1()).isEqualTo(18)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day04(puzzleInput).solvePart1()).isEqualTo(2583)
    }

    @Test
    fun `Part 2 - Example`() {
        assertThat(Day04(exampleInput).solvePart2()).isEqualTo(9)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day04(puzzleInput).solvePart2()).isEqualTo(1978)
    }
}
