package org.example.dp;

import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/12 11:23
 */
public class GetPathCountWithBlocks {

    @Test
    public void test() {

        int[][] arr = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        GetPathCountWithBlocks exe = new GetPathCountWithBlocks();
        System.out.println(exe.getPathCountWithBlocks(arr));
    }

    int getPathCountWithBlocks(int[][] v) {
        int row = v.length;
        int col = v[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = v[0][0] == 1 ? -1 : 1;
        for (int i = 1; i < col; i++) {
            dp[0][i] = v[0][i] == 1 ? -1 : dp[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            dp[i][0] = v[i][0] == 1 ? -1 : dp[i - 1][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (v[i][j] == 1) {
                    dp[i][j] = -1;
                } else {
                    dp[i][j] = (dp[i - 1][j] == -1 ? 0 : dp[i - 1][j]) + (dp[i][j - 1] == -1 ? 0 : dp[i][j - 1]);
                }
            }
        }

        PrintUtil.printArr(dp);

        return dp[row - 1][col - 1] == -1 ? 0 : dp[row - 1][col - 1];
    }
}
