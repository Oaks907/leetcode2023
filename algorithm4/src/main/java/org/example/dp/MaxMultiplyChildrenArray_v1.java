package org.example.dp;

import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/2/29 19:09
 */
public class MaxMultiplyChildrenArray_v1 {

    @Test
    public void test() {

        int[] arr = {-2, 1, -3, 1, -1, 6, 2, -5, 4};

        MaxMultiplyChildrenArray_v1 exe = new MaxMultiplyChildrenArray_v1();
        System.out.println(exe.maxMultiplyChildrenArray(arr, 0, arr.length - 1));
    }

    public int maxMultiplyChildrenArray(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }

        int left = maxMultiplyChildrenArray(arr, start + 1, end);
        int right = maxMultiplyChildrenArray(arr, start, end - 1);

        int multiply = 1;
        for (int i = start; i <= end; i++) {
            multiply *= arr[i];
        }

        return Math.max(Math.max(left, right), multiply);
    }
}
