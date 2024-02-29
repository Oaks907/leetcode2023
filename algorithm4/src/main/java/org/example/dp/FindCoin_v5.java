package org.example.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/2/29 15:52
 */
public class FindCoin_v5 {

    @Test
    public void test() {
        FindCoin_v5 findCoin = new FindCoin_v5();
        System.out.println(findCoin.getMinCountOfCoins());
    }

    int getMinCountOfCoins() {
        int[] values = {1, 2, 3}; // 硬币面值的数组
        int total = 11; // 总值

        int[] dp = new int[total + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= total; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                continue;
            }
            for (int value : values) {
                if (i - value >= 0) {
                    dp[i] = Math.min(dp[i - value] + 1, dp[i]);
                }
            }
        }


        return dp[total] == Integer.MAX_VALUE ? -1 : dp[total];
    }


}
