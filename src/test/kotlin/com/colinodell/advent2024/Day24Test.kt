package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 24: Crossed Wires")
class Day24Test {
    private val exampleInput1 = inputAsListOfString("day24_example1.txt")
    private val exampleInput2 = inputAsListOfString("day24_example2.txt")
    private val puzzleInput = inputAsListOfString("day24_input.txt")

    @Test
    fun `Part 1 - Example 1`() {
        assertThat(Day24(exampleInput1).solvePart1()).isEqualTo(4)
    }

    @Test
    fun `Part 1 - Example 2`() {
        assertThat(Day24(exampleInput2).solvePart1()).isEqualTo(2024)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day24(puzzleInput).solvePart1()).isEqualTo(61495910098126L)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day24(puzzleInput).solvePart2()).isEqualTo("css,cwt,gdd,jmv,pqt,z05,z09,z37")
    }
}
