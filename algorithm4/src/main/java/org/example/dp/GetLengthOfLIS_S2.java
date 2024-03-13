package org.example.dp;

import org.example.util.PrintUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/12 19:22
 */
public class GetLengthOfLIS_S2 {

    @Test
    public void test() {
        int[] arr = {10, 9, 1, 5, 2, 6, 66, 18};
        GetLengthOfLIS_S2 exe = new GetLengthOfLIS_S2();
        System.out.println(exe.findLengthOfLCIS(arr));
    }

    public int findLengthOfLCIS(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = dp[j] + 1;
                    res = Math.max(res, dp[i]);
                }
            }
        }
        PrintUtil.printArr(dp);
        return res;
    }
}
