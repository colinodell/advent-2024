package com.colinodell.advent2024

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class SearchTest {
    @Nested
    inner class FindFirstTrueTests {
        @Test
        fun `returns value when a match exists`() {
            assertThat(binarySearch(1, 10) { it >= 3 }).isEqualTo(3)
            assertThat(binarySearch(1, 1_000_000) { it >= 999_999 }).isEqualTo(999_999)
        }

        @Test
        fun `returns null when no value exists`() {
            assertThat(binarySearch(1, 10) { it >= 11 }).isNull()
        }
    }
}
