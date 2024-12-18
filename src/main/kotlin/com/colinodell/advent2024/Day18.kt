package com.colinodell.advent2024

class Day18(input: List<String>, maxDim: Int) {
    private val region = Region(Vector2(0, 0), Vector2(maxDim, maxDim))
    private val corruptedBytes = input.map {
        it.split(",").let { (x, y) -> Vector2(x.toInt(), y.toInt()) }
    }

    fun solvePart1(bytesFallen: Int) = corruptedBytes
        .take(bytesFallen)
        .toSet()
        .let { fallen -> simulate(fallen).score() }

    fun solvePart2(lowerBound: Int) = binarySearch(lowerBound, corruptedBytes.size) { !pathExists(it) }
        .let { corruptedBytes[it!! - 1].run { "$x,$y" } }

    private fun simulate(fallen: Set<Vector2>) = aStar(
        start = region.topLeft,
        reachedEnd = { it == region.bottomRight },
        nextStates = { current ->
            Direction.entries.mapNotNull { dir ->
                val next = current + dir.vector()
                if (next !in fallen && next in region) next else null
            }
        },
        cost = { _, _ -> 1 },
        heuristic = { it.manhattanDistanceTo(region.bottomRight) },
    )

    private fun pathExists(fallen: Int) = simulate(corruptedBytes.take(fallen).toSet()).foundEnd()
}
