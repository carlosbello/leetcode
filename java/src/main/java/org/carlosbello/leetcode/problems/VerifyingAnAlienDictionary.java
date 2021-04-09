package org.carlosbello.leetcode.problems;

/**
 * 953. Verifying an Alien Dictionary [easy] https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class VerifyingAnAlienDictionary {
    private boolean isSorted(String w1, String w2, int[] order) {
        int i = 0;
        while (i < w1.length() && i < w2.length() && w1.charAt(i) == w2.charAt(i)) {
            i++;
        }
        return (i == w1.length() || i == w2.length())
            ? w1.length() <= w2.length()
            : order[w1.charAt(i) - 'a'] <= order[w2.charAt(i) - 'a'];
    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] charPrecedence = new int[order.length()];
        for (int i = 0; i < order.length(); i++) {
            charPrecedence[order.charAt(i) - 'a'] = i;
        }
        boolean sorted = true;
        int current = 0;
        while (sorted && current < words.length - 1) {
            sorted &= isSorted(words[current], words[current+1], charPrecedence);
            current++;
        }
        return sorted;
    }
}
