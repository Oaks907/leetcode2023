package org.example.dp;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/21 7:32
 **/
public class S0746_minCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }

        int len = cost.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }

        return dp[len];
    }
}
