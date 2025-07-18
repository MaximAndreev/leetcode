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
        val letterCount: MutableMap<Char, Int> = t
            .groupByTo(mutableMapOf()) { it }.mapValues { it.value.size }
            .toMutableMap()
        var charactersToFind = t.length
        var start = 0
        var result: String = ""
        var resultLength = Int.MAX_VALUE
        for ((idx, ch) in s.withIndex()) {
            if (letterCount.containsKey(ch)) {
                if (letterCount[ch]!! > 0) {
                    charactersToFind--
                }
                letterCount[ch] = letterCount[ch]!! - 1
                if (charactersToFind == 0) {
                    while (true) {
                        if (!letterCount.containsKey(s[start])) {
                            start++
                        } else {
                            if (letterCount[s[start]]!! < 0) {
                                letterCount[s[start]] = letterCount[s[start]]!! + 1
                                start++
                            } else {
                                break
                            }
                        }
                    }
                    if (idx - start + 1 < resultLength) {
                        result = s.substring(start, idx + 1)
                        resultLength = result.length
                    }
                }
            }
        }
        return result
    }

    @Test
    fun caseMy0() {
        Assertions.assertEquals("ADOBEC", minWindow("ADOBECODE", "ABC"))
    }

    @Test
    fun caseMy1() {
        Assertions.assertEquals("ADOBEC", minWindow("DFADOBECODE", "ABC"))
    }

    @Test
    fun caseMy2() {
        Assertions.assertEquals("BECA", minWindow("DFADOBECAODE", "ABC"))
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
        Assertions.assertEquals("aa", minWindow("aa", "aa"))
    }

    @Test
    fun case4() {
        Assertions.assertEquals("", minWindow("a", "aa"))
    }
}
