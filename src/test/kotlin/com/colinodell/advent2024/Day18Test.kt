package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 18: RAM Run")
class Day18Test {
    private val exampleInput = inputAsListOfString("day18_example.txt")
    private val puzzleInput = inputAsListOfString("day18_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day18(exampleInput, 6).solvePart1(12)).isEqualTo(22)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day18(puzzleInput, 70).solvePart1(1024)).isEqualTo(360)
    }

    @Test
    fun `Part 2 - Example`() {
        assertThat(Day18(exampleInput, 6).solvePart2(12)).isEqualTo("6,1")
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day18(puzzleInput, 70).solvePart2(1024)).isEqualTo("58,62")
    }
}
