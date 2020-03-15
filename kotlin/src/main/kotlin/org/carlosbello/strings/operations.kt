package org.carlosbello.strings

/**
 * 443. String Compression https://leetcode.com/problems/string-compression/
 *
 * Note: The compression *must* be done *in-place*
 */
fun compress(chars: CharArray): Int {
    fun replaceCharsWithCount(charArr: CharArray, startReplacementIndex: Int, lastCharCount: Int): Int =
        if (lastCharCount > 1) {
            val numberCharArray = lastCharCount.toString().toCharArray()
            for ((index, digit) in numberCharArray.withIndex()) {
                charArr[startReplacementIndex + index] = digit
            }
            numberCharArray.size
        } else 0

    return if (chars.size <= 1)
        chars.size
    else {
        var lastCharIndex = 0
        var charCount = 1

        for (charIndex in 1 .. chars.size) {
            val currentChar = chars.getOrNull(charIndex)
            if(chars[lastCharIndex] == currentChar) {
                charCount++
            } else {
                val insertedDigits = replaceCharsWithCount(chars, lastCharIndex + 1, charCount)
                lastCharIndex += insertedDigits + 1
                currentChar?.let {chars[lastCharIndex] = currentChar}
                charCount = 1
            }
        }

        lastCharIndex
    }
}
