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

    fun rotate(matrix: Array<IntArray>): Unit {

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
        rotate(image)
        assertEquals(expected, image)
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
        assertEquals(expected, image)
    }
}