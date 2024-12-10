package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 10: Hoof It")
class Day10Test {
    private val exampleInput = inputAsListOfString("day10_example.txt")
    private val puzzleInput = inputAsListOfString("day10_input.txt")

    @Test
    fun `Part 1 - Example - Simple`() {
        val exampleInput = """
            ...0...
            ...1...
            ...2...
            6543456
            7.....7
            8.....8
            9.....9
        """.trimIndent().split("\n")
        assertThat(Day10(exampleInput).solvePart1()).isEqualTo(2)
    }

    @Test
    fun `Part 1 - Example - Single Trailhead`() {
        val exampleInput = """
            ..90..9
            ...1.98
            ...2..7
            6543456
            765.987
            876....
            987....
        """.trimIndent().split("\n")
        assertThat(Day10(exampleInput).solvePart1()).isEqualTo(4)
    }

    @Test
    fun `Part 1 - Example - Two Trailheads`() {
        val exampleInput = """
            10..9..
            2...8..
            3...7..
            4567654
            ...8..3
            ...9..2
            .....01
        """.trimIndent().split("\n")
        assertThat(Day10(exampleInput).solvePart1()).isEqualTo(3)
    }

    @Test
    fun `Part 1 - Example - Many Trailheads`() {
        assertThat(Day10(exampleInput).solvePart1()).isEqualTo(36)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day10(puzzleInput).solvePart1()).isEqualTo(468)
    }

    @Test
    fun `Part 2 - Example`() {
        assertThat(Day10(exampleInput).solvePart2()).isEqualTo(81)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day10(puzzleInput).solvePart2()).isEqualTo(966)
    }
}
