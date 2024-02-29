package org.example.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/2/29 16:22
 */
public class MaxSumInArray_v0_1 {

    @Test
    public void test() {

        int[] arr = {-2, 1, -3, 1, -1, 6, 2, -5, 4};

        MaxSumInArray_v0_1 exe = new MaxSumInArray_v0_1();
        System.out.println(exe.maxSumInArray(arr, 0, arr.length - 1));
    }

    private int maxSumInArray(int[] arr, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return arr[startIndex];
        }

        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += arr[i];
        }

        int left = maxSumInArray(arr, startIndex + 1, endIndex);
        int right = maxSumInArray(arr, startIndex, endIndex - 1);

        return Math.max(sum, Math.max(left, right));
    }
}
