package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 16: Reindeer Maze")
class Day16Test {
    private val exampleInput1 = inputAsListOfString("day16_example1.txt")
    private val exampleInput2 = inputAsListOfString("day16_example2.txt")
    private val puzzleInput = inputAsListOfString("day16_input.txt")

    @Test
    fun `Part 1 - Example 1`() {
        assertThat(Day16(exampleInput1).solvePart1()).isEqualTo(7036)
    }

    @Test
    fun `Part 1 - Example 2`() {
        assertThat(Day16(exampleInput2).solvePart1()).isEqualTo(11048)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day16(puzzleInput).solvePart1()).isEqualTo(85432)
    }

    @Test
    fun `Part 2 - Example 1`() {
        assertThat(Day16(exampleInput1).solvePart2()).isEqualTo(45)
    }

    @Test
    fun `Part 2 - Example 2`() {
        assertThat(Day16(exampleInput2).solvePart2()).isEqualTo(64)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day16(puzzleInput).solvePart2()).isEqualTo(465)
    }
}
