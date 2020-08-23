package org.carlosbello.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 301. Remove Invalid Parentheses [hard] https://leetcode.com/problems/remove-invalid-parentheses/
 */
public class RemoveInvalidParentheses {

    /**
     * Accepted solution
     *
     * The idea was to build a solution adding characters while keeping the validation properties. If a new character
     * would invalidate the solution, the build process would be interrupted.
     *
     * In doesn't need to repeatedly check for validity.
     */
    public class Solution2 {
        private String s;
        private int sLength;
        private Set<String> solutions;
        private int bestSolutionDiscardedCount;
        private StringBuilder potentialSolution;

        private boolean isAParentesis(char c) {
            return c == '(' || c == ')';
        }

        private void buildSolutions(int index, int leftCount, int rightCount, int discarded) {
            if (index == sLength) {
                if (leftCount == rightCount) { // is balanced
                    if (discarded < bestSolutionDiscardedCount) {
                        solutions = new HashSet();
                        bestSolutionDiscardedCount = discarded;
                    }
                    if (discarded == bestSolutionDiscardedCount) {
                        solutions.add(potentialSolution.toString());
                    }
                }
                return;
            }

            char c = s.charAt(index);

            if (!isAParentesis(c) || c == '(' || rightCount < leftCount) {
                potentialSolution.append(c);
                buildSolutions(
                        index + 1,
                        leftCount + (c == '(' ? 1 : 0),
                        rightCount + (c == ')' ? 1 : 0),
                        discarded
                );
                potentialSolution.deleteCharAt(potentialSolution.length() - 1);
            }

            if (discarded + 1 <= bestSolutionDiscardedCount) {
                buildSolutions(
                        index + 1,
                        leftCount,
                        rightCount,
                        discarded + 1
                );
            }
        }

        public List<String> removeInvalidParentheses(String s) {
            this.s = s;
            sLength = s.length();
            bestSolutionDiscardedCount = sLength;
            solutions = new HashSet<>();
            potentialSolution = new StringBuilder();

            buildSolutions(0, 0, 0, 0);

            return new ArrayList(solutions);
        }
    }

    /**
     * Valid solution but gets "Time Limit Exceeded".
     *
     * The idea was to build a solution removing characters and check if the string was balanced.
     * Implied to repeatedly check the balance property.
     */
    public class Solition1 {
        private int valueOf(char c) {
            return c == '(' ? +1 : c == ')' ? -1 : 0;
        }

        private boolean isBalanced(String s) {
            int currentBalance = 0;
            for (int index = 0; currentBalance >= 0 && index < s.length(); index++) {
                currentBalance += valueOf(s.charAt(index));
            }
            return currentBalance == 0;
        }

        private String removeCharAt(String s, int index) {
            return s.substring(0, index) + s.substring(index + 1, s.length());
        }

        private boolean isAParentesis(char c) {
            return c == '(' || c == ')';
        }

        private Set<String> removeInvalidParenthesesHelper(String s, int currentSolutionLength) {
            if (s.length() <= 1) {
                return Set.of(isBalanced(s) ? s : "");
            }
            if (s.length() < currentSolutionLength) {
                return Set.of();
            }
            if (s.length() == currentSolutionLength) {
                return isBalanced(s) ? Set.of(s) : Set.of();
            }

            Set<String> solutions = new HashSet<>();
            List<String> versions = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {
                if (!isAParentesis(s.charAt(i))) {
                    continue;
                }
                String version = removeCharAt(s, i);
                versions.add(version);
                if (isBalanced(version)) {
                    solutions.add(version);
                }
            }

            if (solutions.size() > 0) {
                return solutions;
            }

            for (String version : versions) {
                Set<String> foundSolutions = removeInvalidParenthesesHelper(version, currentSolutionLength);
                int newSolutionLength = foundSolutions.isEmpty()
                        ? 0 : foundSolutions.iterator().next().length();
                if (newSolutionLength == currentSolutionLength) {
                    solutions.addAll(foundSolutions);
                } else if (newSolutionLength > currentSolutionLength) {
                    currentSolutionLength = newSolutionLength;
                    solutions = foundSolutions;
                } // ignore smaller solutions
            }

            return solutions;
        }

        public List<String> removeInvalidParentheses(String s) {
            return isBalanced(s) ? List.of(s) : new ArrayList(removeInvalidParenthesesHelper(s, 0));
        }
    }
}
