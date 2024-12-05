package com.colinodell.advent2024

fun Int.clamp(
    min: Int,
    max: Int,
) = maxOf(min, minOf(max, this))
