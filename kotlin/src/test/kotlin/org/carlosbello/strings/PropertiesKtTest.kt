package org.carlosbello.strings

import org.carlosbello.mapFunctionToTestCases
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class PropertiesKtTest {

    @ParameterizedTest(name = "{0} returns {2} given {1}")
    @MethodSource("canPermutePalindromeTestCases")
    fun canPermutePalindrome(canPermutePalindromeFn: (String) -> Boolean, s: String, expectedIsAPermutedPalindrome: Boolean) {
        // when
        val isAPermutedPalindrome = canPermutePalindrome2(s)

        // then
        assertEquals(expectedIsAPermutedPalindrome, isAPermutedPalindrome)
    }


    @ParameterizedTest(name = "isOneEditDistance returns {2} given {0}, {1}")
    @MethodSource("isOneEditDistanceTestCases")
    fun isOneEditDistance(s: String, t: String, expectedIsOneEditDistance: Boolean) {
        // when
        val isOneEditDistance = isOneEditDistance(s, t)

        // then
        assertEquals(expectedIsOneEditDistance, isOneEditDistance)
    }

    companion object {
        @JvmStatic
        fun canPermutePalindromeTestCases(): Stream<Arguments> =
            mapFunctionToTestCases(
                listOf(::canPermutePalindrome1, ::canPermutePalindrome2),
                listOf(
                    arrayOf("", true),
                    arrayOf("a", true),
                    arrayOf("bb", true),
                    arrayOf("abb", true),
                    arrayOf("abab", true),
                    arrayOf("acbcb", true),
                    arrayOf("ab", false),
                    arrayOf("abc", false)
                )
            )

        @JvmStatic
        fun isOneEditDistanceTestCases(): Stream<Arguments> =
            Stream.of(
                Arguments.of("", "", false),
                Arguments.of("a", "a", false),
                Arguments.of("a", "aaa", false),
                Arguments.of("a", "ba", true),
                Arguments.of("a", "ab", true),
                Arguments.of("ab", "ac", true),
                Arguments.of("ba", "ca", true),
                Arguments.of("abc", "adc", true)
            )
    }
}