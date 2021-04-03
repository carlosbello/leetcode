package org.carlosbello.leetcode.problems;

/**
 * 1813. Sentence Similarity III [medium] https://leetcode.com/problems/sentence-similarity-iii/
 */
public class SentenceSimilarityIII {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence2.length() < sentence1.length()) {
            String shorter = sentence2;
            sentence2 = sentence1;
            sentence1 = shorter;
        }
        String[] wordsOfSentence1 = sentence1.split(" ");
        String[] wordsOfSentence2 = sentence2.split(" ");

        int i = 0;
        while (i < wordsOfSentence1.length && wordsOfSentence1[i].equals(wordsOfSentence2[i])) {
            i++;
        }
        int j = 1;
        while (wordsOfSentence1.length - j >= i &&
            wordsOfSentence1[wordsOfSentence1.length - j].equals(wordsOfSentence2[wordsOfSentence2.length - j])) {
            j++;
        }

        return i + j - 1 == wordsOfSentence1.length;
    }
}
