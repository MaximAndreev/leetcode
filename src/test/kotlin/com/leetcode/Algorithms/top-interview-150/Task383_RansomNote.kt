package com.leetcode.Algorithms.`top-interview-150`

import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 * https://leetcode.com/problems/ransom-note/description/
 */
class Task383_RansomNote {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        return false
    }

    @Test
    fun case1() {
        assertFalse { canConstruct("a", "b") }
    }

    @Test
    fun case2() {
        assertFalse { canConstruct("aa", "ab") }
    }

    @Test
    fun case3() {
        assertFalse { canConstruct("aa", "aab") }
    }
}