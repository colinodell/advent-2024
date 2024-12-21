package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 21: Keypad Conundrum")
class Day21Test {
    private val exampleInput = inputAsListOfString("day21_example.txt")
    private val puzzleInput = inputAsListOfString("day21_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day21(exampleInput).solvePart1()).isEqualTo(126384)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day21(puzzleInput).solvePart1()).isEqualTo(162740)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day21(puzzleInput).solvePart2()).isEqualTo(203640915832208L)
    }
}
