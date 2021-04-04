package org.carlosbello.leetcode.problems;

/**
 * 622. Design Circular Queue [medium] https://leetcode.com/problems/design-circular-queue/
 */
public class DesignCircularQueue {
    public static class MyCircularQueue {
        private int[] elements;
        private int frontIndex;
        private int rearIndex;
        private int size;

        public MyCircularQueue(int k) {
            elements = new int[k];
            frontIndex = rearIndex = 0;
            size = 0;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;

            rearIndex = (rearIndex + 1) % elements.length;
            elements[rearIndex] = value;
            size++;
            if (size == 1) {
                frontIndex = rearIndex;
            }
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;

            frontIndex = (frontIndex + 1) % elements.length;
            size--;
            if (size == 0) {
                rearIndex = frontIndex;
            }

            return true;
        }

        public int Front() {
            return isEmpty()
                ? -1
                : elements[frontIndex];

        }

        public int Rear() {
            return isEmpty()
                ? -1
                : elements[rearIndex];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == elements.length;
        }
    }

    /**
     * Your MyCircularQueue object will be instantiated and called as such:
     * MyCircularQueue obj = new MyCircularQueue(k);
     * boolean param_1 = obj.enQueue(value);
     * boolean param_2 = obj.deQueue();
     * int param_3 = obj.Front();
     * int param_4 = obj.Rear();
     * boolean param_5 = obj.isEmpty();
     * boolean param_6 = obj.isFull();
     */
}
