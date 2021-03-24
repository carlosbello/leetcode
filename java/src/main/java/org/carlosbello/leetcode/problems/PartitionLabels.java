package org.carlosbello.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 763. Partition Labels [medium] https://leetcode.com/problems/partition-labels/
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();

        if (S.isEmpty()) return result;

        Set<Character> seen = new HashSet<>();
        int index = 0;
        seen.add(S.charAt(index));
        int lastIndex = S.lastIndexOf(S.charAt(index));
        while (index < lastIndex) {
            index++;
            if (seen.contains(S.charAt(index))) continue;
            seen.add(S.charAt(index));
            lastIndex = Math.max(lastIndex, S.lastIndexOf(S.charAt(index)));
        }
        result.add(index + 1);
        result.addAll(partitionLabels(S.substring(index + 1)));

        return result;
    }
}
