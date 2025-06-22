package com.leetcode.Algorithms.`top-interview-150`

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

/**
 * Given a string s, find the length of the longest substring without duplicate characters.
 *
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
class Task3_LongestSubstringWithoutRepeatingCharacters {

    fun lengthOfLongestSubstringByleetCode(s: String): Int {
        val n: Int = s.length
        var ans = 0
        // index after current character
        val charToNextIndex: MutableMap<Char, Int> = hashMapOf()

        // try to extend the range [i, j]
        var i = 0
        for (j in 0..<n step 1) {
            if (charToNextIndex.containsKey(s[j])) {
                var charIdx: Int = charToNextIndex.getOrDefault(s[j], 0)
                i = max(charIdx, i)
            }
            ans = max(ans, j - i + 1);
            charToNextIndex.put(s[j], j + 1);
        }

        return ans;
    }

    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }
        if (s.length == 1) {
            return 1
        }
        var maxLength = 0
        var left = 0
        val window = mutableSetOf<Char>()
        for (right in s.indices) {
            if (window.contains(s[right])) {
                maxLength = max(maxLength, window.size)
                while (window.contains(s[right])) {
                    window.remove(s[left])
                    left++
                }
            }
            window.add(s[right])
        }
        return max(maxLength, window.size)
    }

    @Test
    fun case1() {
        Assertions.assertEquals(3, lengthOfLongestSubstring("abcabcbb"))
    }

    @Test
    fun case2() {
        Assertions.assertEquals(1, lengthOfLongestSubstring("bbbbb"))
    }

    @Test
    fun case3() {
        Assertions.assertEquals(3, lengthOfLongestSubstring("pwwkew"))
    }

    @Test
    fun case4() {
        Assertions.assertEquals(1, lengthOfLongestSubstring(" "))
    }

    @Test
    fun case5() {
        Assertions.assertEquals(2, lengthOfLongestSubstring("ab"))
    }

    @Test
    fun case6() {
        Assertions.assertEquals(2, lengthOfLongestSubstring("aba"))
    }

    @Test
    fun case7() {
        Assertions.assertEquals(2, lengthOfLongestSubstring("abcdebkf"))
    }
}