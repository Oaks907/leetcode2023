package org.example.other.dynamic;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2023/9/4 11:39
 */
public class Coin_1 {
    int getMinCoinCountOfValue(int total, int[] values, int valueIndex) {
        if (values.length == valueIndex) {
            return Integer.MAX_VALUE;
        }

        int minResult = Integer.MAX_VALUE;
        int currentValue = values[valueIndex];
        int maxCount = total / currentValue;

        // 当前以valueIndex计算最大的填充数量，然后依次减少进行查看
        for (int count = maxCount; count >= 0; count--) {
            // 剩余的数量
            int rest = total - count * currentValue;
            // 如果rest为0，证明余额已用完，组合完成
            if (rest == 0) {
                minResult = Math.min(minResult, count);
                break;
            }

            // 递归，尝试用剩余面值求当前余额的硬币总数
            final int restCount = getMinCoinCountOfValue(rest, values, valueIndex + 1);
            if (restCount == Integer.MAX_VALUE) {
                // 否则尝试把当前面值-1
                continue;
            }
            minResult = Math.min(minResult, count + restCount);
        }

        return minResult;
    }

    int getMinCoinCountLoop(int total, int[] values, int k) {
        int minCount = Integer.MAX_VALUE;
        int valueCount = values.length;

        if (k == valueCount) {
            return Math.min(minCount, getMinCoinCountOfValue(total, values, 0));
        }

        for (int i = k; i < valueCount; i++) {
            // k位置已经排列好
            int t = values[k];
            values[k] = values[i];
            values[i] = t;
            minCount = Math.min(minCount, getMinCoinCountLoop(total, values, k + 1)); // 考虑后一位

            // 回溯
            t = values[k];
            values[k] = values[i];
            values[i] = t;
        }

        return minCount;
    }

    @Test
    public void test() {
        int[] values = {5, 3}; // 硬币面值
        int total = 11; // 总价
        int minCoin = getMinCoinCountLoop(total, values, 0);
        System.out.println(minCoin);
        Assert.assertEquals(3, minCoin);
    }

}
