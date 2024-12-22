package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 22: Monkey Market")
class Day22Test {
    private val exampleInput1 = inputAsListOfString("day22_example1.txt")
    private val exampleInput2 = inputAsListOfString("day22_example2.txt")
    private val puzzleInput = inputAsListOfString("day22_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day22(exampleInput1).solvePart1()).isEqualTo(37327623)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day22(puzzleInput).solvePart1()).isEqualTo(20332089158)
    }

    @Test
    fun `Part 2 - Example`() {
        assertThat(Day22(exampleInput2).solvePart2()).isEqualTo(23)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day22(puzzleInput).solvePart2()).isEqualTo(2191)
    }
}
