package com.leetcode.Algorithms.`top-interview-150`

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Task15_3Sum {

    private fun threeSum(nums: IntArray): List<List<Int>> {
        // 1) Brute force
        // Find all triplets and see if they are zero

        // 2) Either End of an array
        // [-1, 0, 1, 2, -1, -4]
        // sort the array: [-4, -1, -1, 0, 1, 2]
        // -4 - if greater than 0, then next element

          //  2 - if sum is greater than 0, then try to find a negative number
            // if the next negative does not make sum below 0 then finish
            // if it makes below zero then try to find 0
          //  2 - if sum is less than 0, then try to find a positive number
            // if the next positive does not make sum above 0 then finish
            // if it makes above zero then try to find 0
          //  2 - is sum is 0, then try to add 0

        // 3) Central point
        // What if we start from the middle (smallest positive or zero number)?
        // It seems that starting from a central point does not make logic simpler



        return emptyList()
    }

    @Test
    fun explanation() {
        Assertions.assertEquals(
            listOf(intArrayOf(-1, -1, 2), intArrayOf(-1, 0, 1)).toString(),
            threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)).toString()
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
            listOf(intArrayOf(0, 0, 0)).toString(),
            threeSum(intArrayOf(0, 0, 0))
        )
    }
}
