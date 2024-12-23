package com.colinodell.advent2024

import com.colinodell.advent2024.Inputs.inputAsListOfString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Day 23: LAN Party")
class Day23Test {
    private val exampleInput = inputAsListOfString("day23_example.txt")
    private val puzzleInput = inputAsListOfString("day23_input.txt")

    @Test
    fun `Part 1 - Example`() {
        assertThat(Day23(exampleInput).solvePart1()).isEqualTo(7)
    }

    @Test
    fun `Part 1 - Actual`() {
        assertThat(Day23(puzzleInput).solvePart1()).isEqualTo(1269)
    }

    @Test
    fun `Part 2 - Example`() {
        assertThat(Day23(exampleInput).solvePart2()).isEqualTo("co,de,ka,ta")
    }

    @Test
    fun `Part 2 - Actual`() {
        assertThat(Day23(puzzleInput).solvePart2()).isEqualTo("ad,jw,kt,kz,mt,nc,nr,sb,so,tg,vs,wh,yh")
    }
}
