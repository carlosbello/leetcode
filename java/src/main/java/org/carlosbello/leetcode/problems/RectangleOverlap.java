package org.carlosbello.leetcode.problems;

/**
 * 836. Rectangle Overlap [easy] https://leetcode.com/problems/rectangle-overlap/solution/
 */
public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[] leftRec;
        int[] rightRec;
        int[] bottomRec;
        int[] higherRec;
        if (rec1[2] < rec2[2]) {
            leftRec = rec1;
            rightRec = rec2;
        } else {
            leftRec = rec2;
            rightRec = rec1;
        }
        if (rec1[3] < rec2[3]) {
            bottomRec = rec1;
            higherRec = rec2;
        } else {
            bottomRec = rec2;
            higherRec = rec1;
        }
        int base = leftRec[2] - Math.max(leftRec[0], rightRec[0]);
        int high = bottomRec[3] - Math.max(higherRec[1], bottomRec[1]);

        return base > 0 && high > 0;
    }
}
