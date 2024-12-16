package com.colinodell.advent2024

import java.util.PriorityQueue

data class Seen<State>(val cost: Int, val prev: State?)

private data class Scored<State>(val state: State, val cost: Int, private val heuristic: Int) :
    Comparable<Scored<State>> {
    override fun compareTo(other: Scored<State>): Int = (cost + heuristic).compareTo(other.cost + other.heuristic)
}

fun <State> aStar(
    start: State,
    reachedEnd: (State) -> Boolean,
    nextStates: (State) -> Iterable<State>,
    cost: (State, State) -> Int,
    heuristic: (State) -> Int,
) = aStar(setOf(start), reachedEnd, nextStates, cost, heuristic)

fun <State> aStar(
    starts: Iterable<State>,
    reachedEnd: (State) -> Boolean,
    nextStates: (State) -> Iterable<State>,
    cost: (State, State) -> Int = { _, _ -> 1 },
    heuristic: (State) -> Int = { 0 },
): SearchResult<State> {
    val seen: MutableMap<State, Seen<State>> = starts.associateWith { Seen<State>(0, null) }.toMutableMap()
    val next: PriorityQueue<Scored<State>> = PriorityQueue(starts.map { Scored(it, 0, heuristic(it)) })

    while (next.isNotEmpty()) {
        val (state, score) = next.remove()
        if (reachedEnd(state)) {
            return SearchResult(state, seen)
        }

        nextStates(state).forEach { nextState ->
            val newCost = score + cost(state, nextState)
            val oldCost = seen[nextState]?.cost
            if (oldCost == null || newCost < oldCost) {
                seen[nextState] = Seen(newCost, state)
                next.add(Scored(nextState, newCost, heuristic(nextState)))
            }
        }
    }

    return SearchResult(null, seen)
}

class SearchResult<State>(private val end: State?, private val seen: Map<State, Seen<State>>) {
    fun foundEnd() = end != null

    fun end(): State = end ?: throw IllegalStateException("Failed to find a path")

    fun score(): Int = seen[end()]!!.cost

    fun path(): List<State> {
        val path = mutableListOf<State>()
        var current: State? = end()
        while (current != null) {
            path.add(current)
            current = seen[current]!!.prev
        }
        return path.reversed()
    }

    fun costs() = seen.mapValues { it.value.cost }
//
//    fun showPath(grid: MutableMap<State, Char>): Any {
//        val g = grid.toMutableMap()
//        path().forEachIndexed { i, pos ->
//            g[pos] = if (i == 0) 'S' else if (i == path().size - 1) 'E' else 'x'
//        }
//
//        return (g as Grid<Char>).toStringVisualization()
//    }
}
