package org.example.dp;

import org.example.util.PrintUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/12 17:36
 */
public class FindLengthOfLCIS {

    @Test
    public void test() {
        int[] arr = {1, 3, 5, 0, 7};
        FindLengthOfLCIS exe = new FindLengthOfLCIS();
        System.out.println(exe.findLengthOfLCIS(arr));
    }

    public int findLengthOfLCIS(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        PrintUtil.printArr(dp);
        return res;
    }
}
