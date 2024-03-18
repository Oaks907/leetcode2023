package org.example.dp;

import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/15 8:35
 **/
public class S0121_MaxProfit_v2 {

    @Test
    public void test() {

        int[] arr = {7, 1, 5, 3, 6, 4};

        S0121_MaxProfit_v2 exe = new S0121_MaxProfit_v2();
        System.out.println(exe.maxProfit(arr));
    }

    public int maxProfit(int[] prices) {

        int len = prices.length;

        // i：第几天，j: 不动 or 持有 or 卖 ，k: 买卖次数
        int[][][] dp = new int[len][2][2];
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;

        dp[0][1][0] = -prices[0];
        dp[0][1][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);

            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
            dp[i][1][1] = 0;
        }

        PrintUtil.printArr(dp);

        return dp[len - 1][0][1];
    }
}
