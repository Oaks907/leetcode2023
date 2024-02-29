package org.example.dp;

import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/2/28 19:17
 */
public class FindCoin_v3 {

    @Test
    public void test() {
        FindCoin_v3 findCoin = new FindCoin_v3();
        System.out.println(findCoin.getMinCountOfCoins());
    }

    int getMinCountOfCoins() {
        int[] values = {1, 2, 3}; // 硬币面值的数组
        int total = 11; // 总值

        return getMinCountsHelper(total, values); // 求解所有组合（不去重）
    }

    int getMinCountsHelper(int total, int[] values) {
        if (total == 0) {
            return 0;
        }

        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i < values.length; i++) {
            if (total < values[i]) {
                continue;
            }
            int rest = total - values[i];
            int temp = getMinCountsHelper(rest, values);// 求解剩余额度所需硬币数量
            if (temp != Integer.MAX_VALUE) {
                minCount = Math.min(minCount, temp + 1);
            }
        }

        return minCount;
    }
}
