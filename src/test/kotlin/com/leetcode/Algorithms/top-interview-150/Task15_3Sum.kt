package com.leetcode.Algorithms.`top-interview-150`

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * https://leetcode.com/problems/3sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
class Task15_3Sum {

    fun threeSum(nums: IntArray): List<List<Int>> {
        val sortedNums = nums.copyOf().toList().sorted()
        val answer: MutableSet<List<Int>> = mutableSetOf()
        var left = 0
        var right = sortedNums.size - 1
        while (left < right - 1) {
            // Special case
            if (sortedNums[left] == 0 && sortedNums[left + 1] == 0 && sortedNums[left + 2] == 0) {
                answer.add(listOf(0, 0, 0))
                left++
                continue
            }
            // Search for the last number
            val currentSum = sortedNums[left] + sortedNums[right]
            val foundIdx = sortedNums.binarySearch(-currentSum, left + 1, right)
            if (foundIdx >= 0) {
                answer.add(listOf(sortedNums[left], sortedNums[foundIdx], sortedNums[right]).sorted())
                right--
            // Check if it makes sense to search further with picked left index
            } else if (sortedNums[left] < 0 && currentSum >= sortedNums[left] && -currentSum < sortedNums[right]) {
                right--
            } else {
                left++
                right = sortedNums.size - 1
                continue
            }
        }
        return answer.toList()
    }

    @Test
    fun explanation() {
        val threeSum = threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
        Assertions.assertEquals(
            listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)).toString(),
            threeSum.toString()
        )
    }

    @Test
    fun empty() {
        Assertions.assertEquals(
            emptyList<IntArray>(),
            threeSum(intArrayOf(0, 1, 1))
        )
    }

    @Test
    fun onlyOnePossible() {
        Assertions.assertEquals(
            listOf(listOf(0, 0, 0)).toString(),
            threeSum(intArrayOf(0, 0, 0)).toString()
        )
    }

    @Test
    fun shouldBeZero() {
        Assertions.assertEquals(
            emptyList<List<Int>>().toString(),
            threeSum(intArrayOf(1, 2, -2, -1)).toString()
        )
    }

    @Test
    fun longExample() {
        Assertions.assertEquals(
            listOf(
                listOf(-10, 5, 5),
                listOf(-5, 0, 5),
                listOf(-4, 2, 2),
                listOf(-3, -2, 5),
                listOf(-3, 1, 2),
                listOf(-2, 0, 2)
            ).toString(),
            threeSum(intArrayOf(2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10)).toString()
        )
    }

    @Test
    fun missingZero() {
        Assertions.assertEquals(
            listOf(
                listOf(-5, 1, 4),
                listOf(-4, 0, 4),
                listOf(-4, 1, 3),
                listOf(-2, -2, 4),
                listOf(-2, 1, 1),
                listOf(0, 0, 0)
            ).toString(),
            threeSum(intArrayOf(-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0)).toString()
        )
    }
}
