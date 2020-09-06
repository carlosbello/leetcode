package org.carlosbello.leetcode.problems;

/**
 * 1360. Number of Days Between Two Dates [easy] https://leetcode.com/problems/number-of-days-between-two-dates/
 */
public class NumberOfDaysBetweenTwoDates {
    public int daysBetweenDates(String date1, String date2) {
        int day1 = (int)java.time.LocalDate.parse(date1).toEpochDay();
        int day2 = (int)java.time.LocalDate.parse(date2).toEpochDay();

        return Math.max(day1, day2) - Math.min(day1, day2);
    }
}
