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
        if (words.isEmpty()) {
            return emptyList()
        }
        val wordLength = words[0].length
        if (wordLength == 0) {
            return emptyList()
        }
        if (s.length < wordLength * words.size) {
            return emptyList()
        }

        var counter = countWords(words)
        var overallCount = words.size
        var startPosition = 0
        var currentPosition = 0
        val answer: MutableList<Int> = mutableListOf()
        while (startPosition < s.length - wordLength * words.size + 1) {
            val word = s.substring(currentPosition, currentPosition + wordLength)
            val count = counter.get(word)
            if (count == null || count == 0) {
                startPosition++
                currentPosition = startPosition
                if (overallCount != words.size) {
                    counter = countWords(words)
                    overallCount = words.size
                }
                continue
            }
            counter.merge(word, 1, Int::minus)
            overallCount--
            if (overallCount == 0) {
                answer.add(startPosition)
                startPosition++
                currentPosition = startPosition
                counter = countWords(words)
                overallCount = words.size
            } else {
                currentPosition += wordLength
            }
        }
        return answer
    }

    fun countWords(words: Array<String>): MutableMap<String, Int> {
        val counter: MutableMap<String, Int> = mutableMapOf()
        for (word in words) {
            counter.merge(word, 1, Int::plus)
        }
        return counter
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

    @Test
    fun case4() {
        assertEquals(
            emptyList<Int>(),
            findSubstring(
                "",
                arrayOf("bar", "foo", "the")
            )
        )
    }

    @Test
    fun case5() {
        assertEquals(
            emptyList<Int>(),
            findSubstring(
                "barfoofoobarthefoobarman",
                arrayOf("")
            )
        )
    }

    @Test
    fun case6() {
        assertEquals(
            listOf(0, 1, 2),
            findSubstring(
                "aaa",
                arrayOf("a")
            )
        )
    }

    @Test
    fun case7() {
        assertEquals(
            emptyList<Int>(),
            findSubstring(
                "aaa",
                arrayOf("word")
            )
        )
    }
}
