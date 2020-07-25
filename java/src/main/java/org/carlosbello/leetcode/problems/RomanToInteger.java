package org.carlosbello.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer [easy] https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {
    private static final Map<Character, Integer> valueOfLetter = new HashMap<>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    private static final Map<Character, Character> predecessor = new HashMap<>(){{
        put(' ', '-'); // Fake predecessor
        put('I', '-'); // Fake predecessor
        put('V', 'I');
        put('X', 'I');
        put('L', 'X');
        put('C', 'X');
        put('D', 'C');
        put('M', 'C');
    }};

    public int romanToInt(String s) {
        int result = 0;
        char previousChar = ' ';
        for (char currentChar: s.toCharArray()) {
            if (previousChar == predecessor.get(currentChar)) {
                result += valueOfLetter.get(currentChar) - (2 * valueOfLetter.get(previousChar));
            } else {
                result += valueOfLetter.get(currentChar);
            }
            previousChar = currentChar;
        }
        return result;
    }
}
