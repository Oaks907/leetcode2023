package org.example.other.dynamic;

import org.example.util.PrintUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2023/9/4 19:16
 */
public class Coin_4 {
    int getMinCounts(int k, int[] values) {
        int[] memo = new int[k + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0; // 初始化状态

        for (int v = 1; v <= k; v++) {
            int minCount = Integer.MAX_VALUE;
            for (int i = 0; i < values.length; i++) {
                int currentValue = values[i];
                if (currentValue > v) {
                    continue;
                }
                int rest = v - currentValue;
                int restCount = memo[rest];

                if (restCount == -1) {
                    continue;
                }

                minCount = Math.min(minCount, 1 + restCount);
            }
            if (minCount != Integer.MAX_VALUE) {
                memo[v] = minCount;
            }
        }

        PrintUtil.printArr(memo);

        return memo[k];
    }

    @Test
    public void test() {
        int[] values = {5, 3}; // 硬币面值
        int total = 11; // 总价

        int minCoin = this.getMinCounts(total, values);
        Assert.assertEquals(3, minCoin);
    }
}
