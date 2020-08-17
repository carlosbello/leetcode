package org.carlosbello.leetcode.problems;

/**
 * 158. Read N Characters Given Read4 II - Call multiple times [hard] https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/
 */
public class ReadNCharactersGivenRead4IICallMultipleTimes {
    private char[] internalBuf = new char[3];
    private int internalBufSize = 0;

    private int readFromInternalBuffer(char[] buf, int n) {
        int amountToCopy = Math.min(internalBufSize, n);
        System.arraycopy(internalBuf, 0, buf, 0, amountToCopy);
        internalBufSize -= amountToCopy;
        if (internalBufSize > 0) {
            System.arraycopy(internalBuf, amountToCopy, internalBuf, 0, internalBufSize);
        }
        return amountToCopy;
    }

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int totalRead = readFromInternalBuffer(buf, n);
        if (totalRead == n) {
            return totalRead;
        }

        int currentRead = 0;
        int amountToCopy;
        char[] buf4 = new char[4];
        do {
            currentRead = read4(buf4);
            amountToCopy = totalRead + currentRead <= n
                    ? currentRead : (n - totalRead);
            System.arraycopy(buf4, 0, buf, totalRead, amountToCopy);
            totalRead += amountToCopy;
        } while (totalRead < n && currentRead > 0 && currentRead  == amountToCopy);
        internalBufSize = currentRead - amountToCopy;
        if (internalBufSize > 0) {
            System.arraycopy(buf4, amountToCopy, internalBuf, 0, internalBufSize);
        }

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
