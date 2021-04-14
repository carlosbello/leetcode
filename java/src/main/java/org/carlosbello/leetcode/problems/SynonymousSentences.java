package org.carlosbello.leetcode.problems;

import java.util.*;

/**
 * 1258. Synonymous Sentences [medium] https://leetcode.com/problems/synonymous-sentences/
 */
public class SynonymousSentences {
    private String nextWordEndingAt(String text, int lastIndex) {
        int start = text.lastIndexOf(" ", lastIndex - 1);
        return text.substring(start >= 0 ? start + 1 : 0, lastIndex);
    }

    private List<String> buildSynonymSentences(Map<String, Set<String>> synonymsByWord, List<String> sentences, String text) {
        String nextWord;
        for (int lastIndex = text.length(); lastIndex > 0; lastIndex -= nextWord.length() + 1) {
            nextWord = nextWordEndingAt(text, lastIndex);

            List<String> newSentences = new ArrayList<>();

            Set<String> synonyms = synonymsByWord.getOrDefault(nextWord, Set.of());
            if (synonyms.size() == 0) continue;

            for (String sentence: sentences) {
                String left = sentence.substring(0, lastIndex - nextWord.length());
                String right = sentence.substring(lastIndex, sentence.length());
                for (String synonym: synonyms) {
                    newSentences.add(left + synonym + right);
                }
            }
            sentences = newSentences;
        }
        return sentences;
    }

    private void initSynonym(Map<String, Set<String>> synonymsByWord, String word) {
        if (!synonymsByWord.containsKey(word)) {
            synonymsByWord.put(word, new HashSet<>());
            synonymsByWord.get(word).add(word);
        }
    }

    private Map<String, Set<String>> buildSynonymsByWord(List<List<String>> synonyms) {
        Map<String, Set<String>> synonymsByWord = new HashMap<>();
        for (List<String> pair: synonyms) {
            initSynonym(synonymsByWord, pair.get(0));
            initSynonym(synonymsByWord, pair.get(1));
            Set<String> newSynonyms = new HashSet<>(synonymsByWord.get(pair.get(0)));
            newSynonyms.addAll(synonymsByWord.get(pair.get(1)));

            for (String synonym: newSynonyms) {
                synonymsByWord.put(synonym, newSynonyms);
            }
        }
        return synonymsByWord;
    }

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, Set<String>> synonymsByWord = buildSynonymsByWord(synonyms);

        List<String> sentences = buildSynonymSentences(synonymsByWord, new ArrayList<String>(List.of(text)), text);

        sentences.sort(String::compareTo);

        return sentences;
    }
}
