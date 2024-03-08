package org.example.dp.dp_01;

import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/6 19:28
 */
public class dp_01_package {

    @Test
    public void test() {

    }

    /**
     * @param w 重量
     * @param v 价值
     * @param N 最大数量
     * @param W 最大重量
     * @return
     */
    int dp(int[] w, int[] v, int N, int W) {
        int[][] dp = new int[N + 1][W + 1];
        for (int n = 1; n < N + 1; n++) {                   // 遍历物品
            for (int weight = 1; weight <= W; weight++) {   // 背包容量有多大就还要计算多少次
                if (weight < w[n]) {
                    dp[n][weight] = dp[n - 1][weight];
                } else {
                    dp[n][weight] = Math.max(dp[n - 1][weight - w[n]] + v[n], dp[n - 1][weight]);
                }
            }
        }
        return dp[N][W];
    }
}
