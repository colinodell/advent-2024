package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 25: Code Chronicle")
class Day25Test {
    private val exampleInput = inputAsText("day25_example.txt")
    private val puzzleInput = inputAsText("day25_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day25(exampleInput).solvePart1()).isEqualTo(3)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day25(puzzleInput).solvePart1()).isEqualTo(2824)
    }
}
