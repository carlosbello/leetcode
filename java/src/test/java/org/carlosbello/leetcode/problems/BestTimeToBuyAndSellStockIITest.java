package org.carlosbello.leetcode.problems;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockIITest {

    @ParameterizedTest(name = "maxProfit returns {1} given {0}")
    @MethodSource("maxProfitTestCases")
    void maxProfit(int[] givenPrices, int expectedProfix) {
        assertEquals(expectedProfix, BestTimeToBuyAndSellStockII.maxProfit(givenPrices));
    }

    static Stream<Arguments> maxProfitTestCases() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 7),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 4)
        );
    }
}
