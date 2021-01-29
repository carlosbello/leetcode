package org.carlosbello.leetcode.problems;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 273. Integer to English Words [hard] https://leetcode.com/problems/integer-to-english-words/
 */
public class IntegerToEnglishWords {
    private static final Map<Integer, String[]> BASIC_NAME_RULES = Map.of(
            10, new String[]{
                    "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
            },
            20, new String[]{
                    "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
            },
            100, new String[]{
                    "", "X-TEEN", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
            }
    );

    private String nameFromPossition(int possition, Integer[] digits, int displacement) {
        var digit = digits[possition];
        switch (possition + displacement) {
            case 0:
                return BASIC_NAME_RULES.get(10)[digit];
            case 1:
                return digit == 0
                        ? BASIC_NAME_RULES.get(10)[digits[possition - 1]]
                        : digit == 1
                        ? BASIC_NAME_RULES.get(20)[digits[possition - 1]]
                        : BASIC_NAME_RULES.get(100)[digit] + " " + BASIC_NAME_RULES.get(10)[digits[possition - 1]];
            case 2:
                return nameFromPossition(possition, digits, displacement - 2) + " Hundred";
            case 3:
                return nameFromPossition(possition, digits, displacement - 3) + " Thousand";
            case 4:
                return nameFromPossition(possition, digits, displacement - 3) + " Thousand";
            case 5:
                return nameFromPossition(possition, digits, -3) + " " +
                        nameFromPossition(possition - 1, digits, 0);
            case 6:
                return nameFromPossition(possition, digits, -6) + " Million";
            case 7:
                return nameFromPossition(possition, digits, displacement - 6) + " Million";
            case 8:
                return nameFromPossition(possition, digits, -6) + " " +
                        nameFromPossition(possition - 1, digits, 0);
            case 9:
                return nameFromPossition(possition, digits, -9) + " Billion";
            case 10:
                return nameFromPossition(possition, digits, -9) + " Billion";

        }
        return "";
    }

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        var words = new StringBuilder();

        var digitsLst = String.valueOf(num).chars()
                .map(c -> c - '0')
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        Collections.reverse(digitsLst);
        var digits = digitsLst.toArray(Integer[]::new);

        for (int pos = 0; pos < digits.length; pos++) {
            if (digits[pos] == 0) continue;
            if (pos == 0 && pos + 1 < digits.length && digits[pos + 1] > 0) continue;
            if (pos == 3 && (pos + 1 < digits.length && digits[pos + 1] > 0 ||
                    (pos + 2 < digits.length && digits[pos + 2] > 0))) continue;
            if (pos == 4 && pos + 1 < digits.length && digits[pos + 1] > 0) continue;
            if (pos == 6 && (pos + 1 < digits.length && digits[pos + 1] > 0 ||
                    (pos + 2 < digits.length && digits[pos + 2] > 0))) continue;
            if (pos == 7 && pos + 1 < digits.length && digits[pos + 1] > 0) continue;

            words.insert(0, nameFromPossition(pos, digits, 0));
            words.insert(0, " ");
        }

        return words.toString().trim().replaceAll("\\s+", " ");
    }
}
