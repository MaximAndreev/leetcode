package com.leetcode.Algorithms.`top-interview-150`

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 *
 * A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
 *
 * For example, if words = ["ab","cd","ef"],
 * then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings.
 * "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
 * Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 *
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
class Task30_SubstringWithConcatenationOfAllWords {

    fun findSubstring(s: String, words: Array<String>): List<Int> {
        return emptyList()
    }

    @Test
    fun case1() {
        assertEquals(
            listOf(0, 9),
            findSubstring(
                "barfoothefoobarman",
                arrayOf("foo", "bar")
            )
        )
    }

    @Test
    fun case2() {
        assertEquals(
            emptyList<Int>(),
            findSubstring(
                "wordgoodgoodgoodbestword",
                arrayOf("word", "good", "best", "word")
            )
        )
    }

    @Test
    fun case3() {
        assertEquals(
            listOf(6, 9, 12),
            findSubstring(
                "barfoofoobarthefoobarman",
                arrayOf("bar", "foo", "the")
            )
        )
    }
}
