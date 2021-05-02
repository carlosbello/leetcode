package org.carlosbello.leetcode.problems;

import org.carlosbello.leetcode.datastructures.util.Pair;

import java.util.*;

/**
 * 745. Prefix and Suffix Search [hard] https://leetcode.com/problems/prefix-and-suffix-search/
 */
public class PrefixAndSuffixSearch {
    static class WordFilter {

        private List<Pair<String, Integer>> positionByIndex;

        public WordFilter(String[] words) {
            Map<String, Pair<String, Integer>> inserted = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                for (int j = 1; j <= 10 && j <= words[i].length(); j++) {
                    String index = words[i].substring(words[i].length() - j)
                        + "#" + words[i];
                    inserted.put(index, new Pair<>(index, i));
                }
            }
            positionByIndex = new ArrayList<>(inserted.values());
            Collections.sort(positionByIndex, (p1, p2) -> p1.getKey().compareTo(p2.getKey()));
        }

        public int f(String prefix, String suffix) {
            int start = 0;
            int end = positionByIndex.size() - 1;
            int current = (start + end) / 2;
            String search = suffix + "#" + prefix;
            while (start <= end && !positionByIndex.get(current).getKey().startsWith(search)) {
                if (search.compareTo(positionByIndex.get(current).getKey()) < 0) {
                    end = current - 1;
                } else {
                    start = current + 1;
                }
                current = (start + end) / 2;
            }
            if (start > end) {
                return -1;
            }

            int max = positionByIndex.get(current).getValue();
            for (int i = 1; current + i < positionByIndex.size() && positionByIndex.get(current + i).getKey().startsWith(search); i++) {
                max = Math.max(max, positionByIndex.get(current + i).getValue());
            }
            for (int i = 1; current - i >= 0 && positionByIndex.get(current - i).getKey().startsWith(search); i++) {
                max = Math.max(max, positionByIndex.get(current - i).getValue());
            }
            return max;
        }
    }

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
}