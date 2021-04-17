package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * 1209. Remove All Adjacent Duplicates in String II [medium] https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 */
public class RemoveAllAdjacentDuplicatesInStringII {
    private List<Pair<Character, Integer>> encode(String s) {
        List<Pair<Character, Integer>> encoded = new ArrayList<>();

        char prev = s.charAt(0);
        int count = 0;
        for (char c: s.toCharArray()) {
            if (c == prev) {
                count++;
            } else {
                encoded.add(new Pair<>(prev, count));
                prev = c;
                count = 1;
            }
        }
        encoded.add(new Pair<>(prev, count));

        return encoded;
    }

    private String decode(List<Pair<Character, Integer>> encoded) {
        StringBuilder sb = new StringBuilder();
        for (Pair<Character, Integer> charAndCount: encoded) {
            sb.append(String.valueOf(charAndCount.getKey()).repeat(charAndCount.getValue()));
        }
        return sb.toString();
    }

    public String removeDuplicates(String s, int k) {
        List<Pair<Character, Integer>> encoded = encode(s);

        int current = 0;
        while (current < encoded.size()) {
            int newCount = encoded.get(current).getValue() % k;

            if (newCount > 0) {
                encoded.set(current, new Pair<>(encoded.get(current).getKey(), newCount));
                current++;
            } else {
                encoded.remove(current);
                if (current < encoded.size() && current > 0 &&
                    encoded.get(current - 1).getKey().equals(encoded.get(current).getKey())
                ) {
                    encoded.set(current - 1, new Pair<>(
                        encoded.get(current - 1).getKey(),
                        encoded.get(current - 1).getValue() + encoded.get(current).getValue()
                    ));
                    encoded.remove(current);
                    current--;
                }
            }
        }

        return decode(encoded);
    }
}
