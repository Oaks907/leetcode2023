package org.example.dp;

import org.example.util.PrintUtil;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/12 19:22
 */
public class GetLengthOfLIS_S3 {

    @Test
    public void test() {
        int[] arr = {10, 9, 1, 5, 2, 6, 66, 18};
        GetLengthOfLIS_S3 exe = new GetLengthOfLIS_S3();
        System.out.println(exe.findLengthOfLCIS(arr));
    }

    public int findLengthOfLCIS(int[] arr) {
        int len = arr.length;

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int[] count = new int[len];
        Arrays.fill(count, 1);
        int maxLength = 0; // 求出 maxLength

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] += count[j];
                    }
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        PrintUtil.printArr(dp);
        PrintUtil.printArr(count);

        int res = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == maxLength) {
                res += count[i];
            }
        }
        return res;
    }
}
