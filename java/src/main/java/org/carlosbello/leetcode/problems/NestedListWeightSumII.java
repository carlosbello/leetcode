package org.carlosbello.leetcode.problems;

import java.util.List;

/**
 * 364. Nested List Weight Sum II [medium] https://leetcode.com/problems/nested-list-weight-sum-ii/
 */
public class NestedListWeightSumII {
    private int calcHeight(NestedInteger nestedInteger, int currentLevel) {
        if (nestedInteger.isInteger()) {
            return currentLevel;
        }
        int height = currentLevel;
        for (NestedInteger nested: nestedInteger.getList()) {
            height = Math.max(height, calcHeight(nested, currentLevel + 1));
        }
        return height;
    }

    private int calcHeight(List<NestedInteger> nestedList) {
        int height = 0;
        for (NestedInteger nested: nestedList) {
            height = Math.max(height, calcHeight(nested, 1));
        }
        return height;
    }

    private int weightedSum(NestedInteger nestedInteger, int height, int currentLevel) {
        if (nestedInteger.isInteger()) {
            return nestedInteger.getInteger() * (height - currentLevel);
        }
        int sum = 0;
        for (NestedInteger nested: nestedInteger.getList()) {
            sum += weightedSum(nested, height, currentLevel + 1);
        }
        return sum;
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        int height = calcHeight(nestedList);
        int sum = 0;
        for (NestedInteger nested: nestedList) {
            sum += weightedSum(nested, height, 0);
        }
        return sum;
    }

    /**
     * NestedInteger from the problem definition
     */
    interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
