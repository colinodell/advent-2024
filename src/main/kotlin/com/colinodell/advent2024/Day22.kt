package com.colinodell.advent2024

class Day22(input: List<String>) {
    private val secretNumbers = input.map { generate(it.toLong()) }

    fun solvePart1() = secretNumbers.sumOf { it.elementAt(2000) }

    fun solvePart2(): Int {
        val hauls = mutableMapOf<Quad<Int>, Int>()

        secretNumbers.forEach { buyer ->
            val prices = buyer.take(2000 + 1).map { (it % 10).toInt() }.toList()

            prices
                .zipWithNext { a, b -> b - a }
                .windowed(4)
                .mapIndexed { i, seq -> Quad.fromList(seq) to i }
                .distinctBy { it.first }
                .forEach { (seq, i) ->
                    hauls[seq] = hauls.getOrDefault(seq, 0) + prices[i + 4]
                }
        }

        return hauls.values.maxOrNull()!!
    }

    private fun generate(number: Long) = sequence {
        var n = number
        while (true) {
            yield(n)
            n = ((n * 64) xor n) % 16777216
            n = ((n / 32) xor n) % 16777216
            n = ((n * 2048) xor n) % 16777216
        }
    }

    private data class Quad<T>(val a: T, val b: T, val c: T, val d: T) {
        companion object {
            fun <T> fromList(list: List<T>) = Quad(list[0], list[1], list[2], list[3])
        }
    }
}
