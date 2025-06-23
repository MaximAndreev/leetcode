package com.leetcode.Algorithms.`top-interview-150`

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 *
 *
 * https://leetcode.com/problems/minimum-window-substring/
 */
class Task76_MinimumWindowSubstring {

    fun minWindow(s: String, t: String): String {
    return ""
    }


    @Test
    fun case1() {
        Assertions.assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"))
    }

    @Test
    fun case2() {
        Assertions.assertEquals("a", minWindow("a", "a"))
    }

    @Test
    fun case3() {
        Assertions.assertEquals("", minWindow("aa", "aa"))
    }
}