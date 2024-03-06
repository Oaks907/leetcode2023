package org.example.dp;

import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/1 16:14
 */
public class LongestPalindromicSubstring_v2 {

    @Test
    public void test() {
        String str = "babab";

        LongestPalindromicSubstring_v2 exe = new LongestPalindromicSubstring_v2();
        System.out.println(exe.LongestPalindromicSubstring(str));
    }

    private String LongestPalindromicSubstring(String str) {
        if (null == str) {
            return str;
        }
        int length = str.length();

        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        int maxLen = 0;
        int beginIndex = 0;

        for (int step = 2; step <= length; step++) {
            for (int i = 0; i < length; i++) {
                int j = i + step - 1;
                if (j >= length) {
                    break;
                }
                if (str.charAt(i) == str.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    beginIndex = i;
                }
            }
        }

        PrintUtil.printArr(dp);

        return str.substring(beginIndex, maxLen);
    }
}
