package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * 1128. Number of Equivalent Domino Pairs [easy] https://leetcode.com/problems/number-of-equivalent-domino-pairs/
 */
public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Pair<Integer, Integer>, Integer> dominoesRepetitions = new HashMap<>();
        for (int[] d: dominoes) {
            Pair<Integer, Integer> domino = new Pair<>(Math.min(d[0], d[1]), Math.max(d[0], d[1]));
            dominoesRepetitions.put(domino, dominoesRepetitions.getOrDefault(domino, -1) + 1);
        }
        int numberOfPairs = 0;
        for (int repetitions: dominoesRepetitions.values()) {
            numberOfPairs += repetitions * (repetitions + 1) / 2;
        }
        return numberOfPairs;
    }
}
