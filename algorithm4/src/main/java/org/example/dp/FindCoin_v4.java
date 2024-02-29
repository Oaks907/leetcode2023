package org.example.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/2/28 19:45
 */
public class FindCoin_v4 {
    @Test
    public void test() {
        FindCoin_v4 findCoin = new FindCoin_v4();
        System.out.println(findCoin.getMinCountOfCoins());
    }

    int getMinCountOfCoins() {
        int[] values = {1, 2, 3}; // 硬币面值的数组
        int total = 11; // 总值

        int[] memo = new int[total + 1];
        Arrays.fill(memo, -2);

        return getMinCountsHelper(total, values, memo); // 求解所有组合（不去重）
    }

    int getMinCountsHelper(int total, int[] values, int[] memo) {
        if (memo[total] != -2) {
            return memo[total];
        }

        if (total == 0) {
            return 0;
        }

        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < values.length; i++) {
            if (total < values[i]) {
                continue;
            }
            int rest = total - values[i];
            int temp = getMinCountsHelper(rest, values, memo);// 求解剩余额度所需硬币数量
            if (temp != Integer.MAX_VALUE) {
                minCount = Math.min(minCount, temp + 1);
            }
        }

        if (minCount != Integer.MAX_VALUE) {
            memo[total] = minCount;
        }

        return minCount;
    }
}
