package com.colinodell.advent2024

class Day09(private val input: String) {
    fun solvePart1() = calculateChecksum(fragmentBlocks())

    fun solvePart2() = calculateChecksum(defragmentFiles())

    private fun fragmentBlocks(): List<Int?> {
        val data = input.flatMapIndexed { index, char ->
            val count = char.digitToInt()
            if (index % 2 == 0) {
                List(count) { index / 2 }
            } else {
                List(count) { null }
            }
        }.toMutableList()

        var head = 0
        var tail = data.size - 1

        while (head < tail) {
            when {
                data[head] != null -> head++
                data[tail] == null -> tail--
                else -> {
                    data[head++] = data[tail]
                    data[tail--] = null
                }
            }
        }

        return data
    }

    private fun defragmentFiles(): List<Int?> {
        data class File(val size: Int, var id: Int?)

        // Unlike fragmentBlocks(), which moved one block at a time, we're going to move entire files at a time
        val data = input.mapIndexed { index, char ->
            val size = char.digitToInt()
            if (index % 2 == 0) {
                File(size, index / 2)
            } else {
                File(size, null)
            }
        }.toMutableList()

        for (i in data.indices.reversed()) {
            val source = data[i]
            if (source.id == null) continue

            for (j in 0 until i) {
                if (data[j].id == null && data[j].size >= data[i].size) {
                    val dest = data[j]

                    data[i] = File(source.size, null)
                    data[j] = File(source.size, source.id)
                    if (dest.size > source.size) {
                        // We didn't use the entire slot, so set the remainder
                        data.add(j + 1, File(dest.size - source.size, null))
                    }
                    break
                }
            }
        }

        return data.flatMap { file -> List(file.size) { file.id } }
    }

    private fun calculateChecksum(data: List<Int?>) =
        data.mapIndexedNotNull { index, id -> id?.times(index.toLong()) }.sum()
}
