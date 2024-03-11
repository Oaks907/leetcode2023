package org.example.dp;

import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/11 17:36
 */
public class getLongestPalindromeSubseq_v1 {

    @Test
    public void test() {

        getLongestPalindromeSubseq_v1 exe = new getLongestPalindromeSubseq_v1();
        System.out.println(exe.getLongestPalindromeSubseq("asssasms"));
    }

    public int getLongestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        PrintUtil.printArr(dp);

        return dp[1][length - 1];
    }
}
