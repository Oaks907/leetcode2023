package org.example.dp;

import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/9 10:37
 **/
public class LCR088_minCostClimbingStairs {

    @Test
    public void test() {

        int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        LCR088_minCostClimbingStairs exe = new LCR088_minCostClimbingStairs();
        System.out.println(exe.minCostClimbingStairs(arr));
    }

    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i <= cost.length; i++) {

            if (i == cost.length) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]);
            } else {
                dp[i] = Math.min(dp[i - 1] + cost[i], dp[i - 2] + cost[i]);
            }
        }

        return dp[cost.length];
    }
}
