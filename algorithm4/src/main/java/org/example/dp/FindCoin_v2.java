package org.example.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/2/28 17:38
 */
public class FindCoin_v2 {

    @Test
    public void test() {
        FindCoin_v2 findCoin = new FindCoin_v2();
        System.out.println(findCoin.getMinCountOfCoins());
    }

    int getMinCountOfCoins() {
        int[] values = {1, 2, 3}; // 硬币面值的数组
        int total = 11; // 总值

        ArrayList<Integer> initialCounts = new ArrayList<>(Collections.nCopies(values.length, 0)); // 初始值

        ArrayList<List<Integer>> coinCombinations = new ArrayList<>(); // 存储所有组合
        getMinCountsHelper(total, values, initialCounts, coinCombinations); // 求解所有组合（不去重）

        return getMinimumHelper(coinCombinations); // 输出答案
    }

    void getMinCountsHelper(int total, int[] values, ArrayList<Integer> currentCounts, ArrayList<List<Integer>> combinations) {
        if (total == 0) {
            combinations.add(currentCounts);
            return;
        }

        for (int i = 0; i < values.length; i++) {
            if (total < values[i]) {
                continue;
            }
            // 否则在当前面值数量组合上的对应位置加1
            ArrayList<Integer> newCounts = new ArrayList(currentCounts);
            newCounts.set(i, newCounts.get(i) + 1);
            int rest = total - values[i];

            getMinCountsHelper(rest, values, newCounts, combinations); // 求解剩余额度所需硬币数量
        }
    }

    int getMinimumHelper(ArrayList<List<Integer>> combinations) {
        System.out.println(combinations);
        // 如果没有可用组合，返回-1
        if (0 == combinations.size()) {
            return -1;
        }

        int minCount = Integer.MAX_VALUE;
        for (List<Integer> counts : combinations) {
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

}
