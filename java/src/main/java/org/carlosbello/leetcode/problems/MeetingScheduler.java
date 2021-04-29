package org.carlosbello.leetcode.problems;

import java.util.Arrays;
import java.util.List;

/**
 * 1229. Meeting Scheduler [medium] https://leetcode.com/problems/meeting-scheduler/
 */
public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int[][] slots = new int[slots1.length + slots2.length][2];
        System.arraycopy(slots1, 0, slots, 0, slots1.length);
        System.arraycopy(slots2, 0, slots, slots1.length, slots2.length);
        Arrays.sort(
            slots,
            (s1, s2) -> s1[0] == s2[0] ? s1[1] - s2[1] :  s1[0] - s2[0]
        );
        int intersectionIndex = 1;
        for (int i = 0; i < slots.length - 1; i++) {
            for (int j = i + 1;
                 j < slots.length && slots[i][1] > slots[j][0];
                 j++
            ) {
                if (Math.min(slots[i][1], slots[j][1]) - slots[j][0] >= duration) {
                    return List.of(slots[j][0], slots[j][0] + duration);
                }
            }
        }

        return List.of();
    }
}
