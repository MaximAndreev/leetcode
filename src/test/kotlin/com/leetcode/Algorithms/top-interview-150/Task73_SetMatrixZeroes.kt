package com.leetcode.Algorithms.`top-interview-150`

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 *
 * https://leetcode.com/problems/set-matrix-zeroes/description/
 */
class Task73_SetMatrixZeroes {

    fun setZeroes(matrix: Array<IntArray>): Unit {
    }

    @Test
    fun case1() {
        val expected = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0),
            intArrayOf(1, 0, 1),
        )
        val initial = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1),
        )

        for (i in expected.indices step 1) {
            for (j in expected.indices step 1) {
                assertEquals(expected[i][j], initial[i][j])
            }
        }
    }

    @Test
    fun case2() {
        val expected = arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 4, 5, 0),
            intArrayOf(0, 3, 1, 0),
        )
        val initial = arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(3, 4, 5, 2),
            intArrayOf(1, 3, 1, 5),
        )

        for (i in expected.indices step 1) {
            for (j in expected.indices step 1) {
                assertEquals(expected[i][j], initial[i][j])
            }
        }
    }
}
