package org.carlosbello.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. Group Anagrams [medium] https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    private String hashOf(String word) {
        int length = 'z' - 'a' + 1;
        int[] letterCount = new int[length];
        StringBuilder sb = new StringBuilder();
        for(char c: word.toCharArray()) {
            letterCount[c - 'a']++;
        }
        for(int i = 0; i < length; i++) {
            if (letterCount[i] > 0) {
                sb.append((char)('a' + i)).append(letterCount[i]);
            }
        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashToWords = new HashMap<>();
        for (String word: strs) {
            String hash = hashOf(word);
            if (!hashToWords.containsKey(hash)) {
                hashToWords.put(hash, new ArrayList<String>());
            }
            hashToWords.get(hash).add(word);
        }
        return new ArrayList<List<String>>(hashToWords.values());
    }
}
