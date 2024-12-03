package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 3: Mull It Over")
class Day03Test {
    private val example1Input = inputAsText("day03_example1.txt")
    private val example2Input = inputAsText("day03_example2.txt")
    private val puzzleInput = inputAsText("day03_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day03(example1Input).solvePart1()).isEqualTo(161)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day03(puzzleInput).solvePart1()).isEqualTo(171183089)
    }

    @Test
    fun `Part 2 - Example`() {
        assertThat(Day03(example2Input).solvePart2()).isEqualTo(48)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day03(puzzleInput).solvePart2()).isEqualTo(63866497)
    }
}
