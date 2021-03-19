package org.carlosbello.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 346. Moving Average from Data Stream [easy] https://leetcode.com/problems/moving-average-from-data-stream/
 */
public class MovingAverageFromDataStream {
    private int size;
    private Queue<Integer> numbers = new LinkedList<>();
    private int currentSum = 0;

    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        this.size = size;
    }

    public double next(int val) {
        numbers.add(val);
        currentSum += val;
        if (numbers.size() > size) {
            currentSum -= numbers.remove();
        }
        return (double)currentSum / numbers.size();
    }
}
