package org.example.dp;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/26 8:21
 **/
public class LCR161_MaxSales {

    public int maxSales(int[] sales) {

        int len = sales.length;
        int res = sales[0];
        int[] dp = new int[len];
        dp[0] = sales[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max((dp[i - 1] + sales[i]), sales[i]);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
