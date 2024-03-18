package org.example.dp;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/15 8:35
 **/
public class S0121_MaxProfit_v1 {

    public int maxProfit(int[] prices) {

        int len = prices.length;
        int[] maxValue = new int[len];
        maxValue[len - 1] = prices[len - 1];

        for (int i = len - 2; i >= 0; i--) {
            maxValue[i] = Math.max(maxValue[i + 1], prices[i]);
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, maxValue[i] - prices[i]);
        }

        return res;
    }
}
