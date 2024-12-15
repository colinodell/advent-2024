package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 15: Warehouse Woes")
class Day15Test {
    private val exampleInput = inputAsListOfString("day15_example.txt")
    private val puzzleInput = inputAsListOfString("day15_input.txt")

    @Test
    fun `Part 1 - Simple Example`() {
        val example = """
            ########
            #..O.O.#
            ##@.O..#
            #...O..#
            #.#.O..#
            #...O..#
            #......#
            ########

            <^^>>>vv<v>>v<<
        """.trimIndent()
        assertThat(Day15(example.lines()).solvePart1()).isEqualTo(2028)
    }

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day15(exampleInput).solvePart1()).isEqualTo(10092)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day15(puzzleInput).solvePart1()).isEqualTo(1414416)
    }

    @Test
    fun `Part 2 - Example`() {
        assertThat(Day15(exampleInput).solvePart2()).isEqualTo(9021)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day15(puzzleInput).solvePart2()).isEqualTo(1386070)
    }
}
