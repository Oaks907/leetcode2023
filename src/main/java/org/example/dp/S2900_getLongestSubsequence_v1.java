package org.example.dp;

import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/8 8:33
 **/
public class S2900_getLongestSubsequence_v1 {

    @Test
    public void test() {

        String[] str = {"e", "a", "b"};
        int[] arr = {0, 0, 1};

        S2900_getLongestSubsequence_v1 exe = new S2900_getLongestSubsequence_v1();
        System.out.println(exe.getLongestSubsequence(str, arr));
    }

    @Test
    public void test1() {

        String[] str = {"a", "b", "c", "d"};
        int[] arr = {1, 0, 1, 1};

        S2900_getLongestSubsequence_v1 exe = new S2900_getLongestSubsequence_v1();
        System.out.println(exe.getLongestSubsequence(str, arr));
    }

    public Integer getLongestSubsequence(String[] words, int[] groups) {

        int length = groups.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = 1;
        }


        for (int j = 1; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                if (groups[j] == groups[j - 1]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
            }
        }

        PrintUtil.printArr(dp);

        return dp[0][length - 1];
    }
}
