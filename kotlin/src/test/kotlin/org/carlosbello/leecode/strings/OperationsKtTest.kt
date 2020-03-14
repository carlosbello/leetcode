package org.carlosbello.leecode.strings

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class OperationsKtTest {

    @ParameterizedTest(name = "compress returns {2} given {1}")
    @MethodSource("compressTestCases")
    fun compress(givenChars: CharArray, expectedCompressedChars: CharArray) {
        // when
        val compressedSize = compress(givenChars)

        // then
        assertTrue(compressedSize <= givenChars.size)
        assertArrayEquals(expectedCompressedChars, givenChars.sliceArray(0 until compressedSize))
    }

    companion object {
        @JvmStatic
        fun compressTestCases(): Stream<Arguments> =
            Stream.of(
                Arguments.of(charArrayOf(), charArrayOf()),
                Arguments.of(charArrayOf('a'), charArrayOf('a')),
                Arguments.of(charArrayOf('a', 'a'), charArrayOf('a', '2')),
                Arguments.of(charArrayOf('a', 'a', 'b'), charArrayOf('a', '2', 'b')),
                Arguments.of(charArrayOf('a', 'b', 'b'), charArrayOf('a', 'b', '2')),
                Arguments.of(charArrayOf('a', 'b', 'b', 'a'), charArrayOf('a', 'b', '2', 'a')),
                Arguments.of(charArrayOf('a', 'b', 'b', 'b'), charArrayOf('a', 'b', '3')),
                Arguments.of(charArrayOf('a', 'b', 'b', 'b', 'a', 'b'), charArrayOf('a', 'b', '3', 'a', 'b')),
                Arguments.of(
                    charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'a', 'b', 'c'),
                    charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', '1', '2', 'a', 'b', 'c')
                )
            )
    }
}
