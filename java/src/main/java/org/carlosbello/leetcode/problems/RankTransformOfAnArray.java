package org.carlosbello.leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1331. Rank Transform of an Array [easy] https://leetcode.com/problems/rank-transform-of-an-array/
 */
public class RankTransformOfAnArray {
    public int[] arrayRankTransform(int[] arr) {
        Set<Integer> uniqueNumbers = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        List<Integer> sortedNumbers = uniqueNumbers.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        Map<Integer, Integer> numberToRank = new HashMap<>();
        for (int i = 0; i < sortedNumbers.size(); i++) {
            numberToRank.put(sortedNumbers.get(i), i + 1);
        }
        return Arrays.stream(arr).map(numberToRank::get).toArray();
    }
}
