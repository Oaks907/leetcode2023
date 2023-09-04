package org.example.other.dynamic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2023/9/4 17:00
 */
public class Coin_3 {

    int getMinCountsHelper(int total, int[] values, int[] memo) {
        // 取备忘录中的数字，查看是否已计算完成
        int savedMinCount = memo[total];
        if (savedMinCount != -2) {
            return savedMinCount;
        }

        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < values.length; i++) {
            int currentValue = values[i];
            if (currentValue > total) {
                continue;
            }

            final int restCount = this.getMinCountsHelper(total - currentValue, values, memo);
            if (restCount == -1) {
                continue;
            }

            // 保留最小总额
            int totalCount = 1 + restCount;
            if (totalCount < minCount) {
                minCount = totalCount;
            }
        }

        // 如果没有可用组合，返回-1
        if (minCount == Integer.MAX_VALUE) {
            memo[total] = -1;
            return -1;
        }

        memo[total] = minCount; // 记录到备忘录
        return minCount; // 返回最小硬币数量
    }

    @Test
    public void test() {
        int[] values = {5, 3}; // 硬币面值
        int total = 11; // 总价

        int[] memo = new int[total + 1];
        Arrays.fill(memo, -2);
        memo[0] = 0;

        int minCoin = this.getMinCountsHelper(total, values, memo);
        Assert.assertEquals(3, minCoin);
    }


}
