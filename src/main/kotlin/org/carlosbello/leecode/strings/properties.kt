package org.carlosbello.leecode.strings

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
