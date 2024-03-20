package org.example.dp;

import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/19 8:34
 **/
public class S0392_isSubsequence_v1_1 {

    @Test
    public void test() {
        S0392_isSubsequence_v1_1 isSubsequence = new S0392_isSubsequence_v1_1();
        System.out.println(isSubsequence.isSubsequence("ace", "abcde"));
    }

    @Test
    public void test1() {
        S0392_isSubsequence_v1_1 isSubsequence = new S0392_isSubsequence_v1_1();
        System.out.println(isSubsequence.isSubsequence("aca", "abcde"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s == null || "".equals(s)) {
            return true;
        }

        int sLen = s.length();
        int tLen = t.length();
        if (tLen < sLen) {
            return false;
        }

        boolean[][] dp = new boolean[sLen][tLen];
        char c = s.charAt(0);
        for (int i = 0; i < tLen; i++) {
            dp[0][i] = i == 0 ? c == t.charAt(i) : c == t.charAt(i) || dp[0][i - 1];
        }

        for (int i = 1; i < sLen; i++) {
            char a = s.charAt(i);
            for (int j = i; j < tLen; j++) {
                if (a == t.charAt(j) && dp[i - 1][j - 1]) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        PrintUtil.printArr(dp);

        return dp[sLen - 1][tLen - 1];
    }
}
