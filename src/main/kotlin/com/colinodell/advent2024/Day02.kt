package com.colinodell.advent2024

class Day02(input: List<String>) {
    private val reports = input.map { it.split(" ").map(String::toInt) }

    fun solvePart1() = reports.count { isSafe(it) }
    fun solvePart2() = reports.count { isSafe(it, 1) }

    private fun isSafe(report: List<Int>, tolerations: Int = 0): Boolean {
        val safe = report.zipWithNext().all { (a, b) -> b - a in 1..3 } ||
            report.zipWithNext().all { (a, b) -> b - a in -1 downTo -3 }

        // Base case: we're safe, or we've run out of tolerations
        if (safe || tolerations == 0) {
            return safe
        }

        // Try removing each index and see if that makes it safe
        return report.indices.any { i ->
            isSafe(report.filterIndexed { index, _ -> index != i }, tolerations - 1)
        }
    }
}
