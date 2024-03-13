package org.example.dp;

import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/9 10:37
 **/
public class LCR088_minCostClimbingStairs_v2 {

    @Test
    public void test() {

        int[] arr = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        LCR088_minCostClimbingStairs_v2 exe = new LCR088_minCostClimbingStairs_v2();
        System.out.println(exe.minCostClimbingStairs(arr));
    }

    public int minCostClimbingStairs(int[] cost) {

        int prepre = cost[0];
        int pre = cost[1];
        int current = Math.min(prepre, pre);
        for (int i = 2; i <= cost.length; i++) {

            if (i == cost.length) {
                return Math.min(pre, prepre);
            } else {
                current = Math.min(pre + cost[i], prepre + cost[i]);
                prepre = pre;
                pre = current;
            }
        }

        return current;
    }
}
