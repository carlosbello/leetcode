package org.carlosbello.leetcode.problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 341. Flatten Nested List Iterator [medium] https://leetcode.com/problems/flatten-nested-list-iterator/
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

    private final Iterator<Integer> integers;

    private static List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> list = new LinkedList<>();

        for (NestedInteger ni: nestedList) {
            if (ni.isInteger()) {
                list.add(ni.getInteger());
            } else {
                list.addAll(flatten(ni.getList()));
            }
        }

        return list;
    }

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        integers = flatten(nestedList).iterator();
    }

    @Override
    public Integer next() {
        return integers.next();
    }

    @Override
    public boolean hasNext() {
        return integers.hasNext();
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
