package org.example.dp;

import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/11 10:30
 */
public class CountSubstrings_v1 {


    @Test
    public void test() {
        CountSubstrings_v1 exe = new CountSubstrings_v1();
        System.out.println(exe.countSubstrings("abaaba"));
    }

    public int countSubstrings(String str) {
        int length = str.length();
        boolean[][] dp = new boolean[length][length];
        int count = 0;
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            count++;
        }

        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (str.charAt(i) == str.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
