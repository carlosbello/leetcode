package org.carlosbello.leetcode.problems;

import java.util.*;

/**
 * 819. Most Common Word [easy] https://leetcode.com/problems/most-common-word/
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        String[] words = paragraph
                .toLowerCase()
                .replaceAll("!|\\?|'|,|;|\\.", " ")
                .replaceAll("\\s+", " ")
                .split(" ");

        Map<String, Integer> wordsCount = new HashMap<>();
        String mostRepeatedWord = "";
        int mostRepeatedWordCount = 0;
        for (String word: words) {
            if (bannedWords.contains(word)) continue;

            int wordCount = wordsCount.getOrDefault(word, 0) + 1;
            wordsCount.put(word, wordCount);
            if (wordCount > mostRepeatedWordCount) {
                mostRepeatedWord = word;
                mostRepeatedWordCount = wordCount;
            }
        }

        return mostRepeatedWord;
    }
}
