package com.leetcode.Algorithms.`top-interview-150`

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * https://leetcode.com/problems/spiral-matrix/description/
 */
class Task54_SpiralMatrix {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        if (matrix.isEmpty()) {
            return emptyList()
        }

        val right = listOf(1, 0)
        val down = listOf(0, 1)
        val left = listOf(-1, 0)
        val up = listOf(0, -1)

        var currentDirection: List<Int> = right
        var leftToVisit = matrix.size * matrix[0].size
        val spiralOrder = mutableListOf<Int>()
        var x = 0
        var y = 0
        var maxX = matrix[0].size
        var minX = 0
        var maxY = matrix.size
        var minY = 0
        while (leftToVisit > 0) {

            // Store element
            spiralOrder.add(matrix[y][x])
            leftToVisit--

            // Advance
            x += currentDirection[0]
            y += currentDirection[1]

            // Does traversing need to change direction?
            if (x >= maxX || x < minX || y >= maxY || y < minY) {
                val oldDirection = currentDirection.stream().toList()

                // Pick direction
                if (x >= maxX) {
                    currentDirection = down
                    minY++
                } else if (y >= maxY) {
                    currentDirection = left
                    maxX--
                } else if (x < minX) {
                    currentDirection = up
                    maxY--
                } else {
                    currentDirection = right
                    minX++
                }
                // Change advanced step to a new direction
                x -= oldDirection[0]
                y -= oldDirection[1]
                x += currentDirection[0]
                y += currentDirection[1]
            }
        }
        return spiralOrder
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

    @Test
    fun case3() {
        Assertions.assertEquals(
            listOf(1, 2, 3),
            spiralOrder(
                arrayOf(
                    intArrayOf(1, 2, 3)
                )
            )
        )
    }

    @Test
    fun case4() {
        Assertions.assertEquals(
            emptyList<Int>(),
            spiralOrder(
                arrayOf(
                    intArrayOf()
                )
            )
        )
    }

    @Test
    fun case5() {
        Assertions.assertEquals(
            listOf(1, 2, 3),
            spiralOrder(
                arrayOf(
                    intArrayOf(1),
                    intArrayOf(2),
                    intArrayOf(3),
                )
            )
        )
    }

    @Test
    fun case6() {
        Assertions.assertEquals(
            listOf(1, 2, 3, 4, 5, 6),
            spiralOrder(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(6, 3),
                    intArrayOf(5, 4),
                )
            )
        )
    }
}
