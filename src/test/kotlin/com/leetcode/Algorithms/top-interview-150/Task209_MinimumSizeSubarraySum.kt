package com.leetcode.Algorithms.`top-interview-150`

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.Queue

/**
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 *
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 */
class Task209_MinimumSizeSubarraySum {

    /**
     * O(n) solution
     */
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var minSubArraySize: Int = Int.MAX_VALUE
        var currentSum = 0
        var currentSize = 0
        var currentStart = 0
        var currentEnd = 0
        while (currentEnd < nums.size) {
            currentSum += nums[currentEnd]
            currentSize++
            if (currentSum < target) {
                currentEnd++
            } else if (currentSum == target) {
                minSubArraySize = if (minSubArraySize > currentSize) currentSize else minSubArraySize
                currentEnd++
            } else {
                while (currentSum >= target) {
                    minSubArraySize = if (minSubArraySize > currentSize) currentSize else minSubArraySize
                    currentSum -= nums[currentStart]
                    currentStart++
                    currentSize--
                }
                currentEnd++
            }
        }
        return if (minSubArraySize == Int.MAX_VALUE) 0 else minSubArraySize
    }

    @Test
    fun case1() {
        assertEquals(2, minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
    }

    @Test
    fun case2() {
        assertEquals(1, minSubArrayLen(4, intArrayOf(1, 4, 4)))
    }

    @Test
    fun case3() {
        assertEquals(0, minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)))
    }
}
