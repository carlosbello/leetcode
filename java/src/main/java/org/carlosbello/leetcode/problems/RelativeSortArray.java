package org.carlosbello.leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1122. Relative Sort Array [easy] https://leetcode.com/problems/relative-sort-array/
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> arr2ValueToIndex = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            arr2ValueToIndex.put(arr2[i], i);
        }

        return Arrays.stream(arr1).boxed()
            .sorted(
                (n1, n2) -> {
                    if (arr2ValueToIndex.containsKey(n1)) {
                        return arr2ValueToIndex.containsKey(n2)
                            ? arr2ValueToIndex.get(n1) - arr2ValueToIndex.get(n2)
                            : -1;
                    } else {
                        return arr2ValueToIndex.containsKey(n2)
                            ? +1
                            : n1 - n2;
                    }
                }
            )
            .mapToInt(Integer::valueOf)
            .toArray();
    }
}
