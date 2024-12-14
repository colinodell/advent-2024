package com.colinodell.advent2024

inline fun <T> Iterable<T>.productOf(predicate: (T) -> Int): Int = fold(1) { acc, t -> acc * predicate(t) }

fun Int.clamp(
    min: Int,
    max: Int,
) = maxOf(min, minOf(max, this))

fun <T> Collection<T>.permutations() = buildList {
    val p = this@permutations
    for (i in p.indices) {
        for (j in i + 1 until p.size) {
            add(p.elementAt(i) to p.elementAt(j))
        }
    }
}
