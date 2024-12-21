package com.colinodell.advent2024

inline fun <T> Iterable<T>.productOf(predicate: (T) -> Int): Int = fold(1) { acc, t -> acc * predicate(t) }

fun Int.clamp(
    min: Int,
    max: Int,
) = maxOf(min, minOf(max, this))

fun <T> Collection<T>.permutationPairs() = buildList {
    val p = this@permutationPairs
    for (i in p.indices) {
        for (j in i + 1 until p.size) {
            add(p.elementAt(i) to p.elementAt(j))
        }
    }
}

fun <T> Collection<T>.permutations(): List<Collection<T>> {
    if (size == 1) {
        return listOf(this)
    }

    return flatMap { e -> (this - e).permutations().map { listOf(e) + it } }
}
