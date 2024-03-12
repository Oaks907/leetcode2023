package org.example.dp.stock;

import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * 任意交易次数
 *
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/12 16:59
 */
public class Stock_S3_v1 {
    @Test
    public void test() {
        int[] arr = {3, 3, 5, 0, 0, 3, 1, 4};
        Stock_S3_v1 exe = new Stock_S3_v1();
        System.out.println(exe.getMaxStock(arr));
    }

    public int getMaxStock(int[] prices) {
        int freeze = 1;
        int len = prices.length;
        // 天、买 OR 卖、卖出次数
        int k = len / 2;
        int[][][] dp = new int[len][2][k];
        // 第一天，没有买
        for (int i = 0; i < k; i++) {
            dp[0][0][i] = 0;
        }

        // 第一天，买入
        for (int i = 0; i < k; i++) {
            dp[0][1][i] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            dp[i][0][0] = 0;
            for (int m = 1; m < k; m++) {
                if (i - 1 - freeze >= 0) {
                    dp[i][0][m] = Math.max(dp[i - 1 - freeze][1][m - 1] + prices[i], dp[i - 1][0][m]);
                } else {
                    dp[i][0][m] = dp[i - 1][0][m];
                }
            }
            for (int m = 0; m < k; m++) {
                dp[i][1][m] = Math.max(dp[i - 1][0][m] - prices[i], dp[i - 1][1][m]);
            }
            dp[i][1][k - 1] = 0;
        }

        PrintUtil.printArr(dp);
        int res = 0;
        for (int i = 0; i < k; i++) {
            res = Math.max(res, dp[len - 1][0][i]);
        }
        return res;
    }
}
