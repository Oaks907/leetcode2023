package org.example.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/2/29 16:22
 */
public class MaxSumInArray_v0_2 {

    @Test
    public void test() {

        int[] arr = {-2, 1, -3, 1, -1, 6, 2, -5, 4};

        int dp[]  = new int[arr.length];
        Arrays.fill(dp, Integer.MIN_VALUE);

        MaxSumInArray_v0_2 exe = new MaxSumInArray_v0_2();
        System.out.println(exe.maxSumInArray(arr, 0, arr.length - 1, dp));
    }

    private int maxSumInArray(int[] arr, int startIndex, int endIndex, int[] dp) {

        if (dp[startIndex] != Integer.MIN_VALUE) {
            return dp[startIndex];
        }

        for (int i = startIndex; i <= endIndex; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();

        if (startIndex == endIndex) {
            return arr[startIndex];
        }

        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += arr[i];
        }

        int left = maxSumInArray(arr, startIndex + 1, endIndex, dp);
        int right = maxSumInArray(arr, startIndex, endIndex - 1, dp);

        int max = Math.max(sum, Math.max(left, right));
        dp[startIndex] = max;
        return max;
    }
}
