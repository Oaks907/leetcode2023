package org.example.dp;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/2/29 19:09
 */
public class MaxMultiplyChildrenArray_v2 {

    @Test
    public void test() {

        int[] arr = {-2, 1, -3, 1, -1, 6, 2, -5, 4};

        MaxMultiplyChildrenArray_v2 exe = new MaxMultiplyChildrenArray_v2();
        int[] dp = new int[arr.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        System.out.println(exe.maxMultiplyChildrenArray(arr, 0, arr.length - 1, dp));
    }

    public int maxMultiplyChildrenArray(int[] arr, int start, int end, int[] dp) {
        if (start == end) {
            return arr[start];
        }

        if (dp[start] != Integer.MIN_VALUE) {
            return dp[start];
        }

        int left = maxMultiplyChildrenArray(arr, start + 1, end, dp);
        int right = maxMultiplyChildrenArray(arr, start, end - 1, dp);

        int multiply = 1;
        for (int i = start; i <= end; i++) {
            multiply *= arr[i];
        }

        dp[start] = Math.max(Math.max(left, right), multiply);
        return dp[start];
    }
}
