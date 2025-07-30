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

    fun setZeroesUsesExtraSpace(matrix: Array<IntArray>): Unit {
        val zeroRows = mutableListOf<Int>()  // space = matrix.size
        val zeroColumns = mutableListOf<Int>() // space = matrix[0].size
        for (row in matrix.indices) {
            for (column in matrix[0].indices) {
                if (matrix[row][column] == 0) {
                    zeroRows.add(row)
                    zeroColumns.add(column)
                }
            }
        }
        for (row in zeroRows) {
            matrix[row].fill(0)
        }
        for (column in zeroColumns) {
            for (row in matrix.indices) {
                matrix[row][column] = 0
            }
        }
    }

    fun setZeroes(matrix: Array<IntArray>): Unit {
        // Check if the first column should be zero
        var isFirstColZero = false
        for (row in matrix.indices) {
            if (matrix[row][0] == 0) {
                isFirstColZero = true
            }
        }

        // Check if the first row should be zero
        var isFirstRowZero = false
        for (col in matrix[0].indices) {
            if (matrix[0][col] == 0) {
                isFirstRowZero = true
            }
        }

        // Go through matrix and set first col and row to zero if they should be zero
        for (row in 1..<matrix.size) {
            for (col in 1..<matrix[0].size) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0
                    matrix[0][col] = 0
                }
            }
        }

        // Set rows to zero according to marks (the first column)
        for (row in 1..<matrix.size) {
            if (matrix[row][0] == 0) {
                matrix[row].fill(0)
            }
        }

        // Set columns to zero according to marks (the first row)
        for (col in 1..<matrix[0].size) {
            if (matrix[0][col] == 0) {
                for (row in 1..<matrix.size) {
                    matrix[row][col] = 0
                }
            }
        }

        // Set first row and column to zero according to flags
        if (isFirstRowZero) {
            matrix[0].fill(0)
        }
        if (isFirstColZero) {
            for (row in 0..<matrix.size) {
                matrix[row][0] = 0
            }
        }
    }

    @Test
    fun case1() {
        val initial = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1),
        )
        val expected = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0),
            intArrayOf(1, 0, 1),
        )
        setZeroes(initial)
        for (i in expected.indices step 1) {
            for (j in expected.indices step 1) {
                assertEquals(expected[i][j], initial[i][j])
            }
        }
    }

    @Test
    fun case2() {
        val initial = arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(3, 4, 5, 2),
            intArrayOf(1, 3, 1, 5),
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 4, 5, 0),
            intArrayOf(0, 3, 1, 0),
        )
        setZeroes(initial)
        for (i in expected.indices step 1) {
            for (j in expected.indices step 1) {
                assertEquals(expected[i][j], initial[i][j])
            }
        }
    }

    @Test
    fun case3() {
        val initial = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 0, 7, 8),
            intArrayOf(0, 10, 11, 12),
            intArrayOf(13, 14, 15, 0),
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 3, 0),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0),
        )
        setZeroes(initial)
        for (i in expected.indices step 1) {
            for (j in expected.indices step 1) {
                assertEquals(expected[i][j], initial[i][j])
            }
        }
    }
}
