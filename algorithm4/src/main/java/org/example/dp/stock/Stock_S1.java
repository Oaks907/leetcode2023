package org.example.dp.stock;

import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/12 15:57
 */
public class Stock_S1 {

    @Test
    public void test() {
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
        Stock_S1 exe = new Stock_S1();
        System.out.println(exe.getMaxStock(arr));
    }

    public int getMaxStock(int[] prices) {
        int len = prices.length;
        // 天、买 OR 卖、买卖次数
        int[][][] dp = new int[len][2][3];
        // 第一天，没有买
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        dp[0][0][2] = 0;

        // 第一天，买入
        dp[0][1][0] = -prices[0];
        dp[0][1][1] = -prices[0];
        dp[0][1][2] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);

            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
            dp[i][1][1] = Math.max(dp[i - 1][0][1] - prices[i], dp[i - 1][1][1]);
            dp[i][1][2] = 0;
        }

        PrintUtil.printArr(dp);
        return Math.max(dp[len - 1][0][1], dp[len - 1][0][2]);
    }
}
