package org.carlosbello.leetcode.problems;

/**
 * 11. Container With Most Water [medium] https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    private int containerArea(int from, int to, int[] height) {
        return (to - from) * Math.min(height[from], height[to]);
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int biggestContainer = containerArea(left, right, height);
        int currentHeight;

        while (left < right) {
            if (height[left] <= height[right]) {
                currentHeight = height[left];
                while (left < right && height[left] <= currentHeight) {
                    left++;
                }
            } else {
                currentHeight = height[right];
                while (left < right && height[right] <= currentHeight) {
                    right--;
                }
            }
            if (left < right) {
                int currentContainer = containerArea(left, right, height);
                if (currentContainer > biggestContainer) {
                    biggestContainer = currentContainer;
                }
            }
        }

        return biggestContainer;
    }
}
