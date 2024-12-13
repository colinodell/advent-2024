package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 13: Claw Contraption")
class Day13Test {
    private val exampleInput = inputAsText("day13_example.txt")
    private val puzzleInput = inputAsText("day13_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day13(exampleInput).solvePart1()).isEqualTo(480)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day13(puzzleInput).solvePart1()).isEqualTo(26810)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day13(puzzleInput).solvePart2()).isEqualTo(108713182988244L)
    }
}
