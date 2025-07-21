package com.leetcode.Algorithms.`top-interview-150`

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *  - A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 *  - Only the filled cells need to be validated according to the mentioned rules.
 */
class Task36_ValidSudoku {

    fun isValidSudoku(board: Array<CharArray>): Boolean {

        // Walking rows
        for (row in board.indices) {
            val metNumbers = mutableSetOf<Char>()
            for (col in board[0].indices) {
                if (board[row][col] != '.' && metNumbers.contains(board[row][col])) {
                    return false
                } else {
                    metNumbers.add(board[row][col])
                }
            }
        }

        // Walking columns
        for (col in board[0].indices) {
            val metNumbers = mutableSetOf<Char>()
            for (row in board.indices) {
                if (board[row][col] != '.' && metNumbers.contains(board[row][col])) {
                    return false
                } else {
                    metNumbers.add(board[row][col])
                }
            }
        }

        val subBoxes = mutableMapOf<Int, MutableSet<Char>>()
        for (j in 0..<3) {
            for (i in 0..<3) {
                subBoxes[i + j * 3] = mutableSetOf()
                for (col in 0..<3) {
                    for (row in 0..<3) {
                        val actualRow = row + j * 3
                        val actualCol = col + i * 3
                        if (board[actualRow][actualCol] != '.' && subBoxes[i+j*3]!!.contains(board[actualRow][actualCol])) {
                            return false
                        } else {
                            subBoxes[i+j*3]!!.add(board[actualRow][actualCol])
                        }

                    }
                }
            }
        }

        return true
    }

    @Test
    fun case1() {
        val board: Array<CharArray> = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
        assertTrue(isValidSudoku(board))
    }

    @Test
    fun case2() {
        val board: Array<CharArray> = arrayOf(
            charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
        assertFalse(isValidSudoku(board))
    }

    @Test
    fun case3() {
        val board: Array<CharArray> = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '1', '8', '.', '.', '7', '9')
        )
        assertFalse(isValidSudoku(board))
    }
}
