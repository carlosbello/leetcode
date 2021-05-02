package org.carlosbello.leetcode.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 630. Course Schedule III [hard] https://leetcode.com/problems/course-schedule-iii/
 */
public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (c1, c2) -> c1[1] == c2[1]
            ? Integer.compare(c1[0], c2[0])
            : Integer.compare(c1[1], c2[1]));
        Queue<int[]> selectedCourses = new PriorityQueue<>((c1, c2) -> Integer.compare(c2[0], c1[0]));
        int currentDay = 0;

        for (int currentCourse = 0; currentCourse < courses.length; currentCourse++) {
            if (currentDay + courses[currentCourse][0] <= courses[currentCourse][1]) {
                currentDay += courses[currentCourse][0];
                selectedCourses.add(courses[currentCourse]);
            } else if (!selectedCourses.isEmpty() && selectedCourses.peek()[0] > courses[currentCourse][0]) {
                currentDay += courses[currentCourse][0] - selectedCourses.poll()[0];
                selectedCourses.add(courses[currentCourse]);
            }
        }

        return selectedCourses.size();
    }
}
