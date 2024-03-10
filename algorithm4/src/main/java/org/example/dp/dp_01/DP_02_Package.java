package org.example.dp.dp_01;

import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/8 16:37
 */
public class DP_02_Package {


    @Test
    public void test() {
        int[] arr = {1, 2};
        DP_02_Package exe = new DP_02_Package();
        System.out.println(exe.latestStone(arr));
    }

    public int latestStone(int[] weights) {

        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
        }

        int row = weights.length + 1;
        int col = sum / 2 + 1;
        int[][] dp = new int[row][col];

        for (int i = 1; i < row; i++) {
            for (int canWeight = 0; canWeight < col; canWeight++) {

                int curWeight = weights[i - 1];

                if (canWeight < curWeight) {
                    dp[i][canWeight] = dp[i - 1][canWeight];
                } else {
                    dp[i][canWeight] = Math.max(dp[i - 1][canWeight], dp[i - 1][canWeight - curWeight] + curWeight);
                }
            }
        }

        PrintUtil.printArr(dp);

        return sum - dp[row - 1][col - 1] * 2;
    }

}
