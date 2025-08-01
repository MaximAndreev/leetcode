package com.leetcode.Algorithms.`top-interview-150`

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * https://leetcode.com/problems/rotate-image/description/
 */
class Task48_RotateImage {

    // The right solution - transpose and swap symmetric columns
    // https://www.baeldung.com/cs/rotate-2d-matrix
    fun rotate(matrix: Array<IntArray>): Unit {
        var min = 0
        var max = matrix.size - 1
        while (min < max) {
            var topLeft = Pair(min, min)
            var topRight = Pair(min, max)
            var downRight = Pair(max, max)
            var downLeft = Pair(max, min)

            for (i in min..<max step 1) {
                swap(matrix, topLeft, topRight)
                swap(matrix, topLeft, downRight)
                swap(matrix, topLeft, downLeft)
                topLeft = topLeft.copy(topLeft.first, topLeft.second + 1)
                topRight = topRight.copy(topRight.first + 1, topRight.second)
                downRight = downRight.copy(downRight.first, downRight.second - 1)
                downLeft = downLeft.copy(downLeft.first - 1, downLeft.second)
            }
            // Shrink matrix
            min++
            max--
        }
        print("Done")
    }

    fun swap(matrix: Array<IntArray>, a: Pair<Int, Int>, b: Pair<Int, Int>) {
        val tmp = matrix[a.first][a.second]
        matrix[a.first][a.second] = matrix[b.first][b.second]
        matrix[b.first][b.second] = tmp
    }

    @Test
    fun case0() {
        val expected = arrayOf(
            intArrayOf(4, 1),
            intArrayOf(3, 2),
        )
        val image = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(4, 3),
        )
        rotate(image)
        for (i in expected.indices step 1) {
            for (j in expected.indices step 1) {
                assertEquals(expected[i][j], image[i][j])
            }
        }
    }

    @Test
    fun case1() {
        val expected = arrayOf(
            intArrayOf(7, 4, 1),
            intArrayOf(8, 5, 2),
            intArrayOf(9, 6, 3)
        )
        val image = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )

        val image_transpose = arrayOf(
            intArrayOf(1, 4, 7),
            intArrayOf(2, 5, 8),
            intArrayOf(3, 6, 9)
        )
        val image_swap_symmetric_colums = arrayOf(
            intArrayOf(7, 4, 1),
            intArrayOf(8, 5, 2),
            intArrayOf(9, 6, 3)
        )

        rotate(image)
        for (i in expected.indices step 1) {
            for (j in expected.indices step 1) {
                assertEquals(expected[i][j], image[i][j])
            }
        }
    }

    @Test
    fun case2() {
        val expected = arrayOf(
            intArrayOf(15, 13, 2, 5),
            intArrayOf(14, 3, 4, 1),
            intArrayOf(12, 6, 8, 9),
            intArrayOf(16, 7, 10, 11)
        )
        val image = arrayOf(
            intArrayOf(5, 1, 9, 11),
            intArrayOf(2, 4, 8, 10),
            intArrayOf(13, 3, 6, 7),
            intArrayOf(15, 14, 12, 16)
        )
        rotate(image)
        for (i in expected.indices step 1) {
            for (j in expected.indices step 1) {
                assertEquals(expected[i][j], image[i][j])
            }
        }
    }

    @Test
    fun case3() {
        val expected = arrayOf(
            intArrayOf(4)
        )
        val image = arrayOf(
            intArrayOf(4)
        )
        rotate(image)
        for (i in expected.indices step 1) {
            for (j in expected.indices step 1) {
                assertEquals(expected[i][j], image[i][j])
            }
        }
    }
}