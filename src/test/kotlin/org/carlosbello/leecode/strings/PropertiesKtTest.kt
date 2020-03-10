package org.carlosbello.leecode.strings

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

    }
}