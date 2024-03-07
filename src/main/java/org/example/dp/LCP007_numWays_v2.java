package org.example.dp;

import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/6 7:55
 **/
public class LCP007_numWays_v2 {

    @Test
    public void test() {

        int[][] arr = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};

        LCP007_numWays_v2 exe = new LCP007_numWays_v2();
        System.out.println(exe.numWays(5, arr, 3));
    }

    public int numWays(int n, int[][] relation, int k) {
        int row = relation.length;
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;

        for (int i = 1; i <= k; i++) {
            for (int[] edge : relation) {
                int src = edge[0];
                int dst = edge[1];
                dp[i][dst] += dp[i - 1][src];
            }
        }

        return dp[k][n - 1];
    }
}
