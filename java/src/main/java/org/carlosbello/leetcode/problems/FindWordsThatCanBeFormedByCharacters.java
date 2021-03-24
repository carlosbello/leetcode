package org.carlosbello.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 1160. Find Words That Can Be Formed by Characters [easy] https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */
public class FindWordsThatCanBeFormedByCharacters {
    private Map<Character, Integer> buildCharsCount(String word) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c: word.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;
    }

    private boolean isGood(Map<Character, Integer> wordCharsCount, Map<Character, Integer> baseCharsCount) {
        return wordCharsCount.entrySet().stream()
                .allMatch(charCount ->
                        baseCharsCount.containsKey(charCount.getKey()) &&
                                baseCharsCount.get(charCount.getKey()) >= charCount.getValue());
    }

    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> baseCharsCount = buildCharsCount(chars);
        int count = 0;

        for (String word: words) {
            Map<Character, Integer> wordCharsCount = buildCharsCount(word);
            count += isGood(wordCharsCount, baseCharsCount) ? word.length() : 0;
        }

        return count;
    }
}
