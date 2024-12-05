package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 5: Print Queue")
class Day05Test {
    private val exampleInput = inputAsListOfString("day05_example.txt")
    private val puzzleInput = inputAsListOfString("day05_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day05(exampleInput).solvePart1()).isEqualTo(143)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day05(puzzleInput).solvePart1()).isEqualTo(5129)
    }
}
