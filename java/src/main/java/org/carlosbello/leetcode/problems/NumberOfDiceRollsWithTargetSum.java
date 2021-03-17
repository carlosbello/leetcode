package org.carlosbello.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 1155. Number of Dice Rolls With Target Sum [medium] https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 */
public class NumberOfDiceRollsWithTargetSum {
    private static final int mod = (int)(Math.pow(10, 9) + 7);
    private Map<Integer, Integer> numRollsSeen;
    private int f;

    private int numRollsToTarget(int d, int target) {
        if (target < d) return 0;
        if (d == 1) return target <= f ? 1 : 0;

        int diceAndTarget = d * 10000 + target;
        if (numRollsSeen.containsKey(diceAndTarget)) return numRollsSeen.get(diceAndTarget);

        int numRolls = 0;
        for (int i = 1; i <= f; i++) {
            numRolls = (numRolls + numRollsToTarget(d - 1, target - i)) % mod;
        }
        numRollsSeen.put(diceAndTarget, numRolls);

        return numRolls;
    }

    public int numRollsToTarget(int d, int f, int target) {
        this.f = f;
        numRollsSeen = new HashMap<>();
        return numRollsToTarget(d, target);
    }
}
