package org.example.dp;

import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/12 11:11
 */
public class GetPathCount {

    @Test
    public void test() {
        GetPathCount exe = new GetPathCount();
        System.out.println(exe.getPathCount(3, 2));
    }

    public int getPathCount(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
