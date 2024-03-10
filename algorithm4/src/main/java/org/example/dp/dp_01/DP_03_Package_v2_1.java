package org.example.dp.dp_01;

import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/8 17:46
 */
public class DP_03_Package_v2_1 {

    @Test
    public void test() {
        int N = 3, W = 5; // 物品的总数，背包能容纳的总重量
        int[] w = {0, 3, 2, 1}; // 物品的重量
        int[] v = {0, 5, 2, 3}; // 物品的价值
        DP_03_Package_v2_1 exe = new DP_03_Package_v2_1();
        System.out.println(exe.bag(w, v, N, W));
    }


    int bag(int[] weights, int[] values, int canTake, int canWeight) {
        int[][] dp = new int[2][canWeight + 1];

        for (int n = 1; n <= canTake; n++) {
            for (int weight = 1; weight <= canWeight; weight++) {
                int ctn = n % 2;
                // 1 - ctn代表上一行的缓存索引
                int ptn = 1 - ctn;
                dp[ctn][weight] = dp[ptn][weight];
                if (weights[n] <= weight) {
                    dp[ctn][weight] = Math.max(dp[ctn][weight], dp[ctn][weight - weights[n]] + values[n]);
                }
            }
        }

        PrintUtil.printArr(dp);
        return dp[canTake % 2][canWeight];
    }
}
