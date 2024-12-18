package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 17: Chronospatial Computer")
class Day17Test {
    private val exampleInput1 = inputAsListOfString("day17_example1.txt")
    private val exampleInput2 = inputAsListOfString("day17_example2.txt")
    private val puzzleInput = inputAsListOfString("day17_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day17(exampleInput1).solvePart1()).isEqualTo("4,6,3,5,6,3,5,2,1,0")
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day17(puzzleInput).solvePart1()).isEqualTo("7,6,1,5,3,1,4,2,6")
    }

    @Test
    fun `Part 2 - Example`() {
        assertThat(Day17(exampleInput2).solvePart2()).isEqualTo(117440)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day17(puzzleInput).solvePart2()).isEqualTo(164541017976509L)
    }
}
