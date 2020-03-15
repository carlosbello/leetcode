package org.carlosbello.strings

import kotlin.math.abs

/**
 * 266. Palindrome Permutation https://leetcode.com/problems/palindrome-permutation/
 *
 * Approach: For each char, count the amount of times it appears in the string. A palindrome should have at most one
 * character with an odd number of appearances
 */
fun canPermutePalindrome1(s: String): Boolean =
    s.groupBy { it }
        .mapValues { it.value.size % 2 == 1 }
        .values.fold(0) {
            oddCharCount, isOddChar -> if (isOddChar) oddCharCount + 1 else oddCharCount
        } <= 1

/**
 * Similar to {@link canPermutePalindrome1} but avoiding the intermediate creation of a list of repeated chars for each
 * unique char in the string and early returning if more than one odd char group is found
 */
fun canPermutePalindrome2(s: String): Boolean {
    val charCount = mutableMapOf<Char, Int>()
    var oddCharCountFound = false
    for (char in s)
        charCount[char] = charCount.getOrDefault(char, 0) + 1
    for (count in charCount.values) {
        if (count % 2 == 1)
            if (!oddCharCountFound) {
                oddCharCountFound = true
            } else {
                return false
            }
    }
    return true
}

/**
 * 161. One Edit Distance https://leetcode.com/problems/one-edit-distance/
 */
fun isOneEditDistance(s: String, t: String): Boolean =
    when {
        abs(s.length - t.length) > 1 || s.length + t.length == 0 -> false
        s.length + t.length == 1 -> true
        s[0] == t[0] -> isOneEditDistance(s.substring(1), t.substring(1))
        s.length == t.length -> s.substring(1) == t.substring(1)
        s.length < t.length -> s == t.substring(1)
        else -> s.substring(1) == t
    }
