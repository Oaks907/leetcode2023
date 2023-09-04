package org.example.other.dynamic;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2023/9/4 14:52
 */
public class Coin_2 {
    void getMinCountsHelper(int total, int[] values, ArrayList<Integer> currentCounts, ArrayList<ArrayList<Integer>> combinations) {
        if (total == 0) {
            combinations.add(new ArrayList<>(currentCounts));
            return;
        }

        for (int i = 0; i < values.length; i++) {
            int currentValue = values[i];
            if (currentValue > total) {
                continue;
            }
            // 否则在当前面值数量组合上的对应位置加1
            ArrayList<Integer> newCounts = new ArrayList<Integer>(currentCounts);
            newCounts.set(i, newCounts.get(i) + 1);
            this.getMinCountsHelper(total - currentValue, values, newCounts, combinations);
        }
    }

    int getMinimumHelper(ArrayList<ArrayList<Integer>> combinations) {
        // 如果没有可用组合，返回-1
        if (0 == combinations.size()) {
            return -1;
        }

        int minCount = Integer.MAX_VALUE;
        for (ArrayList<Integer> counts : combinations) {
            int total = 0; // 求当前组合的硬币总数
            for (int count : counts) {
                total += count;
            }

            // 保留最小的
            if (total < minCount) {
                minCount = total;
            }
        }

        return minCount;
    }

    @Test
    public void test() {
        int[] values = {5, 3}; // 硬币面值
        int total = 11; // 总价
        ArrayList<Integer> currentCounts = new ArrayList<>(Collections.nCopies(values.length, 0));
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();

        getMinCountsHelper(total, values, currentCounts, combinations);
        int minCoin = getMinimumHelper(combinations);
        Assert.assertEquals(3, minCoin);
    }

}
