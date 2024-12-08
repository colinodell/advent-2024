package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 8: Resonant Collinearity")
class Day08Test {
    private val exampleInput = inputAsListOfString("day08_example.txt")
    private val puzzleInput = inputAsListOfString("day08_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day08(exampleInput).solvePart1()).isEqualTo(14)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day08(puzzleInput).solvePart1()).isEqualTo(252)
    }

    @Test
    fun `Part 2 - Example`() {
        assertThat(Day08(exampleInput).solvePart2()).isEqualTo(34)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day08(puzzleInput).solvePart2()).isEqualTo(839)
    }
}
