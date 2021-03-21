package org.carlosbello.leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 126. Word Ladder II [hard] https://leetcode.com/problems/word-ladder-ii/
 */
public class WordLadderII {
    private void initConnections(String word, Map<String, Set<String>> connections) {
        if (!connections.containsKey(word)) {
            connections.put(word, new HashSet<>());
        }
    }

    private boolean areAdjacent(String w1, String w2) {
        int diffCount = 0;
        for (int i = 0; i < w1.length() && diffCount <= 1; i++) {
            diffCount += w1.charAt(i) == w2.charAt(i) ? 0 : 1;
        }
        return diffCount <= 1;
    }

    private Map<String, Set<String>> buildWordConnections(Set<String> wordList) {
        Map<String, Set<String>> connections = new HashMap<>();
        List<String> words = new ArrayList<>(wordList);

        for (int i = 0; i < words.size() - 1; i++) {
            String wordI = words.get(i);
            for (int j = i + 1; j < words.size(); j++) {
                String wordJ = words.get(j);
                if (areAdjacent(wordI, wordJ)) {
                    initConnections(wordI, connections);
                    initConnections(wordJ, connections);
                    connections.get(wordI).add(wordJ);
                    connections.get(wordJ).add(wordI);
                }
            }
        }

        return connections;
    }

    private List<List<String>> buildPaths(int lastStep, Map<Integer, List<String>> wordsByStep, String beginWord, String endWord, Map<String, Set<String>> wordConnections) {
        List<List<String>> paths = new ArrayList<>();
        paths.add(new ArrayList<>(List.of(endWord)));
        int step = lastStep;

        while (step > 0) {
            List<List<String>> newPaths = new ArrayList<>();
            for (List<String> path: paths) {
                Set<String> nextWords = new HashSet<>(wordConnections.get(path.get(0)));
                nextWords.retainAll(wordsByStep.get(step));
                for (String word: nextWords) {
                    List<String> newPath = new ArrayList<>(path);
                    newPath.add(0, word);
                    newPaths.add(newPath);
                }
            }
            paths = newPaths;
            step--;
        }

        paths.forEach(path -> path.add(0, beginWord));

        return paths;
    }

    private List<List<String>> findShortestPaths(String beginWord, String endWord, Map<String, Set<String>> wordConnections) {
        Set<String> toVisit = wordConnections.get(beginWord);
        Set<String> visited = new HashSet<>();
        Map<Integer, List<String>> wordsByStep = new HashMap<>();
        wordsByStep.put(0, List.of(beginWord));
        visited.add(beginWord);
        int step = 0;

        while (!toVisit.isEmpty() && !toVisit.contains(endWord)) {
            step++;
            wordsByStep.put(step, new ArrayList<>(toVisit));
            visited.addAll(toVisit);

            toVisit = toVisit.stream()
                    .map(wordConnections::get)
                    .flatMap(Set::stream)
                    .filter(word -> !visited.contains(word))
                    .collect(Collectors.toSet());
        }

        return toVisit.contains(endWord)
                ? buildPaths(step, wordsByStep, beginWord, endWord, wordConnections)
                : List.of();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> modifiedWordList = new HashSet<>(wordList);
        modifiedWordList.add(beginWord); // Ensure beginWord is in wordList

        if (!modifiedWordList.contains(endWord)) return List.of(); // endWord can't be reached

        Map<String, Set<String>> wordConnections = buildWordConnections(modifiedWordList);

        if (!wordConnections.containsKey(beginWord)) return List.of(); // beginWord has no connections

        return findShortestPaths(beginWord, endWord, wordConnections);
    }
}
