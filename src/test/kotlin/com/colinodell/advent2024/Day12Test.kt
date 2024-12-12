package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 12: Garden Groups")
class Day12Test {
    private val exampleInput = inputAsListOfString("day12_example.txt")
    private val puzzleInput = inputAsListOfString("day12_input.txt")

    private val simpleExample1 = """
        AAAA
        BBCD
        BBCC
        EEEC
    """.trimIndent().split("\n")

    private val simpleExample2 = """
        OOOOO
        OXOXO
        OOOOO
        OXOXO
        OOOOO
    """.trimIndent().split("\n")

    private val eShapedRegion = """
        EEEEE
        EXXXX
        EEEEE
        EXXXX
        EEEEE
    """.trimIndent().split("\n")

    private val touchesDiagonally = """
        AAAAAA
        AAABBA
        AAABBA
        ABBAAA
        ABBAAA
        AAAAAA
    """.trimIndent().split("\n")

    @Test
    fun `Part 1 - Simple Example 1`() {
        assertThat(Day12(simpleExample1).solvePart1()).isEqualTo(140)
    }

    @Test
    fun `Part 1 - Simple Example 2`() {
        assertThat(Day12(simpleExample2).solvePart1()).isEqualTo(772)
    }

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day12(exampleInput).solvePart1()).isEqualTo(1930)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day12(puzzleInput).solvePart1()).isEqualTo(1370258)
    }

    @Test
    fun `Part 2 - Simple Example 1`() {
        assertThat(Day12(simpleExample1).solvePart2()).isEqualTo(80)
    }

    @Test
    fun `Part 2 - Simple Example 2`() {
        assertThat(Day12(simpleExample2).solvePart2()).isEqualTo(436)
    }

    @Test
    fun `Part 2 - E-Shaped Region`() {
        assertThat(Day12(eShapedRegion).solvePart2()).isEqualTo(236)
    }

    @Test
    fun `Part 2 - Touches Diagonally`() {
        assertThat(Day12(touchesDiagonally).solvePart2()).isEqualTo(368)
    }

    @Test
    fun `Part 2 - Example`() {
        assertThat(Day12(exampleInput).solvePart2()).isEqualTo(1206)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day12(puzzleInput).solvePart2()).isEqualTo(805814)
    }
}
