package org.carlosbello.leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 127. Word Ladder [hard] https://leetcode.com/problems/word-ladder/
 */
public class WordLadder {
    private void addConnection(String beginWord, String relative, Map<String, Set<String>> wordConnections) {
        if (!wordConnections.containsKey(beginWord)) {
            wordConnections.put(beginWord, new HashSet<>());
        }
        if (!wordConnections.containsKey(relative)) {
            wordConnections.put(relative, new HashSet<>());
        }
        wordConnections.get(beginWord).add(relative);
        wordConnections.get(relative).add(beginWord);
    }

    private boolean differInOnlyOneLetter(String w1, String w2) {
        int i = 0;
        int differCount = 0;
        do {
            differCount += w1.charAt(i) == w2.charAt(i) ? 0 : 1;
            i++;
        } while (i < w1.length() && differCount <= 1);
        return differCount <= 1;
    }

    private Map<String, Set<String>> buildWordConnections(List<String> wordList) {
        Map<String, Set<String>> wordConnections = new HashMap<>();

        for (int i = 0; i < wordList.size() - 1; i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                if (differInOnlyOneLetter(wordList.get(i), wordList.get(j))) {
                    addConnection(wordList.get(i), wordList.get(j), wordConnections);
                }
            }
        }

        return wordConnections;
    }

    private int shortestPath(String beginWord, String endWord, Map<String, Set<String>> wordConnections) {
        List<String> toVisit = new ArrayList<>(wordConnections.get(beginWord));
        Set<String> visited = new HashSet<>();
        int step = 1;
        visited.add(beginWord);

        while (!toVisit.isEmpty() && !toVisit.contains(endWord)) {
            step++;
            visited.addAll(toVisit);
            toVisit = toVisit.stream()
                    .map(wordConnections::get)
                    .flatMap(Set::stream)
                    .filter(word -> !visited.contains(word))
                    .collect(Collectors.toList());
        }

        return toVisit.isEmpty() ? 0 : step + 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> extendedWordList = new HashSet<>(wordList);
        if (!wordList.contains(endWord)) return 0;

        extendedWordList.add(beginWord);

        Map<String, Set<String>> wordConnections = buildWordConnections(
                new ArrayList<>(extendedWordList)
        );

        return !wordConnections.containsKey(beginWord)
                ? 0
                : shortestPath(beginWord, endWord, wordConnections);
    }
}
