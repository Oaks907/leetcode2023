package org.example.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/2/29 16:12
 */
public class MaxSumInArray_v1 {

    @Test
    public void test() {

        int[] arr = {-2, 1, -3, 1, -1, 6, 2, -5, 4};

        MaxSumInArray_v1 exe = new MaxSumInArray_v1();
        System.out.println(exe.maxSumInArray(arr));
    }

    private int maxSumInArray(int[] arr) {

        int[] dp = new int[arr.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = arr[0];
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
