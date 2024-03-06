package org.example.dp;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/2 10:43
 */
public class LongestBigChildrenArray_v1 {


    @Test
    public void test() {

        int[] arr = {10, 9, 2, 5, 3, 7, 66, 18};

        LongestBigChildrenArray_v1 exe = new LongestBigChildrenArray_v1();
        System.out.println(exe.longestBigChildrenArray(arr));
    }

    private int longestBigChildrenArray(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int length = arr.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);

        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < length; i++) {
            int val = arr[i];
            for (int j = 0; j < i; j++) {
                if (val >= arr[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
