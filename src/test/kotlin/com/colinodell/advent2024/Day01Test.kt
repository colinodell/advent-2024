package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 1: Historian Hysteria")
class Day01Test {
    private val exampleInput = inputAsListOfString("day01_example.txt")
    private val puzzleInput = inputAsListOfString("day01_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day01(exampleInput).solvePart1()).isEqualTo(11)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day01(puzzleInput).solvePart1()).isEqualTo(1830467)
    }

    @Test
    fun `Part 2 - Example`() {
        assertThat(Day01(exampleInput).solvePart2()).isEqualTo(31)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day01(puzzleInput).solvePart2()).isEqualTo(26674158)
    }
}
