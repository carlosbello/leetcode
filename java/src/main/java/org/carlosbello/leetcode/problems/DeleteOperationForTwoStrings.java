package org.carlosbello.leetcode.problems;

/**
 * 583. Delete Operation for Two Strings [medium] https://leetcode.com/problems/delete-operation-for-two-strings/
 */
public class DeleteOperationForTwoStrings {
    private int minDist(int startAt1, int startAt2, Integer[][] memo, String word1, String word2) {
        if (word1.length() == startAt1 || word2.length() == startAt2) {
            return (word1.length() - startAt1) + (word2.length() - startAt2);
        }
        if (memo[startAt1][startAt2] != null) return memo[startAt1][startAt2];

        if (word1.charAt(startAt1) == word2.charAt(startAt2)) {
            memo[startAt1][startAt2] = minDist(startAt1 + 1, startAt2 + 1, memo, word1, word2);
        } else {
            memo[startAt1][startAt2] = Math.min(
                2 + minDist(startAt1 + 1, startAt2 + 1, memo, word1, word2),
                1 + Math.min(
                    minDist(startAt1 + 1, startAt2, memo, word1, word2),
                    minDist(startAt1, startAt2 + 1, memo, word1, word2)
                )
            );
        }

        return memo[startAt1][startAt2];
    }

    public int minDistance(String word1, String word2) {
        Integer[][] memo = new Integer[word1.length()][word2.length()];
        return minDist(0, 0, memo, word1, word2);
    }
}
