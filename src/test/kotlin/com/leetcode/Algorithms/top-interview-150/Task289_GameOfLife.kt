package com.leetcode.Algorithms.`top-interview-150`

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 *
 * The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.
 *
 * Given the current state of the board, update the board to reflect its next state.
 *
 * Note that you do not need to return anything.
 *
 * https://leetcode.com/problems/game-of-life/description/
 */
class Task289_GameOfLife {

    fun gameOfLife(board: Array<IntArray>): Unit {
        // Walk through all cells and decide their fate
        // Mark transitions with a sentinel value
        // Walk second time and replace transitions

        val toAlive = 10  // 0 -> 1
        val toDead = -10 // 1 -> 0
        val aliveMarkers = setOf(1, toDead)

        for (row in board.indices) {
            for (col in board[0].indices) {

                // Count alive neighbours
                var aliveNeighbours = 0
                for (rowN in row - 1..row + 1) {
                    if (rowN < 0 || rowN == board.size) {
                        continue
                    }
                    for (colN in col - 1..col + 1) {
                        if (colN < 0 || colN == board[0].size) {
                            continue
                        }
                        if (rowN == row && colN == col) {
                            continue
                        }
                        if (aliveMarkers.contains(board[rowN][colN])) {
                            aliveNeighbours++
                        }
                    }
                }

                // Rules
                // Any live cell
                var state = board[row][col]
                if (aliveMarkers.contains(board[row][col])) {
                    // with fewer than two live neighbors dies as if caused by under-population.
                    if (aliveNeighbours < 2) {
                        state = toDead
                    }
                    // with two or three live neighbors lives on to the next generation.
                    if (aliveNeighbours == 2 || aliveNeighbours == 3) {
                        state = board[row][col]
                    }
                    // with more than three live neighbors dies, as if by over-population.
                    if (aliveNeighbours > 3) {
                        state = toDead
                    }
                // Any dead cell
                } else {
                    // with exactly three live neighbors becomes a live cell, as if by reproduction.
                    if (aliveNeighbours == 3) {
                        state = toAlive
                    }
                }
                board[row][col] = state
            }
        }

        for (row in board.indices) {
            for (col in board[0].indices) {
                if (board[row][col] == toDead) {
                    board[row][col] = 0
                } else if (board[row][col] == toAlive) {
                    board[row][col] = 1
                }
            }
        }
    }

    @Test
    fun case1() {
        val initial = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(0, 0, 0),
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(1, 0, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(0, 1, 0),
        )
        gameOfLife(initial)
        for (row in expected.indices) {
            for (col in expected[0].indices) {
                assertEquals(expected[row][col], initial[row][col])
            }
        }
    }

    @Test
    fun case2() {
        val initial = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 0),
        )
        val expected = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1),
        )
        gameOfLife(initial)
        for (row in expected.indices) {
            for (col in expected[0].indices) {
                assertEquals(expected[row][col], initial[row][col])
            }
        }
    }
}