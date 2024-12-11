package com.colinodell.advent2024

class Day11(input: String) {
    private val stones = input.split(" ").map(String::toLong)

    fun solvePart1() = blink(stones, 25)

    fun solvePart2() = blink(stones, 75)

    private val cache = mutableMapOf<Pair<Long, Int>, Long>()

    private fun blink(stones: List<Long>, times: Int): Long {
        // Base case - we're done blinking
        if (times == 0) {
            return stones.size.toLong()
        }

        // Given multiple stones, blink them individually and sum the results
        if (stones.size > 1) {
            return stones.sumOf { blink(listOf(it), times) }
        }

        val stone = stones[0]

        // Memoization
        val cacheKey = Pair(stone, times)
        if (cache.containsKey(cacheKey)) {
            return cache[cacheKey]!!
        }

        // Blink the individual stone once
        val newStones = when {
            stone == 0L -> listOf(1L)
            hasEvenDigits(stone) -> splitDigits(stone)
            else -> listOf(stone * 2024L)
        }

        // Blink the resulting stones
        val result = blink(newStones, times - 1)

        cache[cacheKey] = result

        return result
    }

    private fun hasEvenDigits(number: Long) = number.toString().length % 2 == 0

    private fun splitDigits(number: Long) = number.toString().chunked(number.toString().length / 2).map(String::toLong)
}
