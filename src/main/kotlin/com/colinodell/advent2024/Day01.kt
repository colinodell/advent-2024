package com.colinodell.advent2024

import kotlin.math.absoluteValue

class Day01(input: List<String>) {
    private val lists =
        input
            .map { it.split(Regex("\\s+")).map(String::toInt) }
            .map { it[0] to it[1] }
            .unzip()
            .let { (a, b) -> a.sorted() to b.sorted() }

    fun solvePart1() = lists.first.zip(lists.second).sumOf { (a, b) -> (a - b).absoluteValue }
    fun solvePart2() = lists.first.sumOf { a -> a * lists.second.count { it == a } }
}
