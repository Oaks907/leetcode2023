package org.example.dp;

import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/2/27 14:35
 */
public class FindCoin {

    @Test
    public void test() {
        FindCoin findCoin = new FindCoin();
        System.out.println(findCoin.getMinCoinCountOfValue());
    }

    int getMinCoinCountOfValue(int total, int[] values, int valueIndex) {

        int valueCount = values.length;
        if (valueIndex == valueCount) {
            return Integer.MAX_VALUE;
        }

        int minResult = Integer.MAX_VALUE;
        int currentValue = values[valueIndex];
        int maxCount = total / currentValue;

        for (int count = maxCount; count >= 0; count--) {
            int rest = total - count * currentValue;
            // 如果rest为0，表示余额已除尽，组合完成
            if (rest == 0) {
                minResult = Math.min(minResult, count);
                break;
            }
            int restCount = getMinCoinCountOfValue(rest, values, valueIndex + 1);

            if (restCount == Integer.MAX_VALUE) {
                if (count == 0) {
                    break;
                }
                continue;
            }

            minResult = Math.min(minResult, count + restCount);
        }

        return minResult;
    }

    public int getMinCoinCountLoop(int total, int[] values, int k) {
        int minCount = Integer.MAX_VALUE;
        int valueCount = values.length;


        if (valueCount == k) {
            return Math.min(minCount, getMinCoinCountOfValue(total, values, 0));
        }

        for (int i = k; i <= valueCount - 1; i++) {
            int temp = values[k];
            values[k] = values[i];
            values[i] = temp;

            minCount = Math.min(minCount, this.getMinCoinCountLoop(total, values, k + 1));

            temp = values[k];
            values[k] = values[i];
            values[i] = temp;
        }

        for (int value : values) {
            System.out.print(value + ", ");
        }
        System.out.println();

        System.out.println("-->" + minCount);
        return minCount;
    }

    int getMinCoinCountOfValue() {
        int[] values = {1, 2, 3}; // 硬币面值
        int total = 11; // 总价
        int minCoin = getMinCoinCountLoop(total, values, 0);

        return (minCoin == Integer.MAX_VALUE) ? -1 : minCoin;  // 输出答案
    }
}

