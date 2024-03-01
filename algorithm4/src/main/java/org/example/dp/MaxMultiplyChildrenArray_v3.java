package org.example.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/2/29 19:09
 */
public class MaxMultiplyChildrenArray_v3 {

    @Test
    public void test() {

        int[] arr = {-2, 1, -3, 1, -1, 6, 2, -5, 4};

        MaxMultiplyChildrenArray_v3 exe = new MaxMultiplyChildrenArray_v3();

        System.out.println(exe.maxMultiplyChildrenArray(arr));
    }

    public int maxMultiplyChildrenArray(int[] arr) {
        int[][] dp = new int[2][arr.length];
        dp[0][0] = arr[0];
        dp[1][0] = arr[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            dp[0][i] = Math.max(Math.max(dp[0][i - 1] * val, val), dp[1][i - 1] * val);
            dp[1][i] = Math.min(Math.min(dp[0][i - 1] * val, val), dp[1][i - 1] * val);
            ans = Math.max(Math.max(dp[0][i], dp[1][i]), ans);
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + ", ");
            }
            System.out.println();
        }

        return ans;
    }
}
