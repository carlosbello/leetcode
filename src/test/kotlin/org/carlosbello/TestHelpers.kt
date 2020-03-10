package org.carlosbello

import org.junit.jupiter.params.provider.Arguments
import java.util.stream.Stream
import kotlin.streams.asStream

fun <F> mapFunctionToTestCases(functions: Iterable<F>, testCases: Iterable<Array<out Any?>>): Stream<Arguments> =
    functions.flatMap { fn ->
        testCases.map { testParams ->
            Arguments.of(fn, *testParams)
        }
    }.asSequence().asStream()