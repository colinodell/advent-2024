package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsText
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 9: Disk Fragmenter")
class Day09Test {
    private val exampleInput = inputAsText("day09_example.txt")
    private val puzzleInput = inputAsText("day09_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day09(exampleInput).solvePart1()).isEqualTo(1928)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day09(puzzleInput).solvePart1()).isEqualTo(6337367222422L)
    }

    @Test
    fun `Part 2 - Example`() {
        assertThat(Day09(exampleInput).solvePart2()).isEqualTo(2858)
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day09(puzzleInput).solvePart2()).isEqualTo(6361380647183L) // 6428159425913 is too high; 477293914 is too low; 534081807 is not right
    }
}
