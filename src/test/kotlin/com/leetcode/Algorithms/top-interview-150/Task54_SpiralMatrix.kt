package com.leetcode.Algorithms.`top-interview-150`

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 */
class Task54_SpiralMatrix {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        return listOf()
    }

    @Test
    fun case1() {
        Assertions.assertEquals(
            listOf(1, 2, 3, 6, 9, 8, 7, 4, 5),
            spiralOrder(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9)
                )
            )
        )
    }

    @Test
    fun case2() {
        Assertions.assertEquals(
            listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
            spiralOrder(
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                    intArrayOf(9, 10, 11, 12)
                )
            )
        )
    }
}
