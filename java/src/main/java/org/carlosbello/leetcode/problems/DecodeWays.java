package org.carlosbello.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 91. Decode Ways [medium] https://leetcode.com/problems/decode-ways/
 */
public class DecodeWays {
    /**
     * Recursive calls with copies of the substring of n * (n-1) / 2 lengths,
     * So O(n^2) additional space is used.
     * Slower because of the space used and the substring operations.
     */
    public class Solution1 {
        private Map<String, Integer> decodings = new HashMap<>();

        private boolean isValidCode (String s){
            return s.charAt(0) == '1' || s.charAt(0) == '2' && s.charAt(1) <= '6';
        }

        public int numDecodings (String s){
            if (decodings.containsKey(s)) return decodings.get(s);
            if (!s.isEmpty() && s.charAt(0) == '0') return 0;
            if (s.length() <= 1) return 1;

            int waysToDecodeUsingFirstChar = numDecodings(s.substring(1));
            int waysToDecodeUsingTwoFirstChars = isValidCode(s.substring(0, 2))
                    ? numDecodings(s.substring(2))
                    : 0;
            int waysToDecode = waysToDecodeUsingFirstChar + waysToDecodeUsingTwoFirstChars;

            decodings.put(s, waysToDecode);

            return waysToDecode;
        }
    }

    /**
     * Faster solution with lower memory usage and no substring operations
     */
    class Solution2 {
        private Map<Integer, Integer> decodings;
        private String s;

        private boolean isValidCode(int startAtIndex) {
            return s.charAt(startAtIndex) == '1' ||
                    s.charAt(startAtIndex) == '2' && s.charAt(startAtIndex + 1) <= '6';
        }

        public int waysToDecodeString(int startAtIndex) {
            if (decodings.containsKey(startAtIndex)) return decodings.get(startAtIndex);
            if (startAtIndex < s.length() && s.charAt(startAtIndex) == '0') return 0;
            if (startAtIndex >= s.length() - 1) return 1;

            int waysToDecodeUsingFirstChar = waysToDecodeString(startAtIndex + 1);
            int waysToDecodeUsingTwoFirstChars = isValidCode(startAtIndex)
                    ? waysToDecodeString(startAtIndex + 2)
                    : 0;
            int waysToDecode = waysToDecodeUsingFirstChar + waysToDecodeUsingTwoFirstChars;

            decodings.put(startAtIndex, waysToDecode);

            return waysToDecode;
        }

        public int numDecodings(String s) {
            decodings = new HashMap<>();
            this.s = s;

            return waysToDecodeString(0);
        }
    }
}
