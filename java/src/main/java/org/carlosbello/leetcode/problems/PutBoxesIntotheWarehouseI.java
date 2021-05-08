package org.carlosbello.leetcode.problems;

import java.util.Arrays;

/**
 * 1564. Put Boxes Into the Warehouse I [medium] https://leetcode.com/problems/put-boxes-into-the-warehouse-i/
 */
public class PutBoxesIntotheWarehouseI {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);
        int min = Integer.MAX_VALUE;
        int boxInWarehouseCount = 0;

        for (int i = 0; i < warehouse.length; i++) {
            if (warehouse[i] > min) {
                warehouse[i] = min;
            } else if (warehouse[i] < min) {
                min = warehouse[i];
            }
        }

        int boxIndex = 0;
        int warehouseIndex = warehouse.length - 1;
        while (boxIndex < boxes.length && warehouseIndex >= 0) {
            if (warehouse[warehouseIndex] >= boxes[boxIndex]) {
                boxInWarehouseCount++;
                boxIndex++;
            }
            warehouseIndex--;
        }

        return boxInWarehouseCount;
    }
}
