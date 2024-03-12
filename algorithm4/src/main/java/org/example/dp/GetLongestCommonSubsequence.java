package org.example.dp;

import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/12 10:48
 */
public class GetLongestCommonSubsequence {

    @Test
    public void test() {
        GetLongestCommonSubsequence exe = new GetLongestCommonSubsequence();
        System.out.println(exe.getLongestCommonSubsequence("abcde", "ade"));
    }

    public int getLongestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1][len2];
        char c = text1.charAt(0);
        for (int i = 0; i < len2; i++) {
            dp[0][i] = c == text2.charAt(i) ? 1 : 0;
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len1 - 1][len2 - 1];
    }
}
