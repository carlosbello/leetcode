package org.carlosbello.leetcode.problems;

/**
 * 157. Read N Characters Given Read4 [easy] https://leetcode.com/problems/read-n-characters-given-read4/
 */
public class ReadNCharactersGivenRead4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int totalRead = 0;
        int currentRead;
        char[] buf4 = new char[4];
        do {
            currentRead = read4(buf4);
            int amountToCopy = totalRead + currentRead <= n
                    ? currentRead : (n - totalRead);
            System.arraycopy(buf4, 0, buf, totalRead, amountToCopy);
            totalRead += amountToCopy;
        } while (totalRead < n && currentRead > 0);
        return totalRead;
    }

    /**
     * Dumb read4 implementation. As leetcode problem description say:
     *
     *  The read4 API is defined in the parent class Reader4.
     *      int read4(char[] buf4);
     */
    private int read4(char[] buf4) {
        return 0;
    }
}
