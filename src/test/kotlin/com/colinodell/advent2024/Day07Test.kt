package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 7: Bridge Repair")
class Day07Test {
    private val exampleInput = inputAsListOfString("day07_example.txt")
    private val puzzleInput = inputAsListOfString("day07_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day07(exampleInput).solvePart1()).isEqualTo(3749)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day07(puzzleInput).solvePart1()).isEqualTo(4998764814652L)
    }

    @Test
    fun `Part 2 - Example`() {
        assertThat(Day07(exampleInput).solvePart2()).isEqualTo(11387)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day07(puzzleInput).solvePart2()).isEqualTo(37598910447546L)
    }
}
