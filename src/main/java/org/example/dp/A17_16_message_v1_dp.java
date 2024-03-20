package org.example.dp;

import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/21 0:18
 **/
public class A17_16_message_v1_dp {

    @Test
    public void test() {
        int[] arr = {2,1,4,5,3,1,1,3};
        A17_16_message_v1_dp exe = new A17_16_message_v1_dp();
        System.out.println(exe.massage(arr));
    }

    public int massage(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (j - i == 1) {
                    dp[i][j] = Math.max(nums[i], nums[j]);
                } else {
                    dp[i][j] = Math.max(dp[i][j - 2] + nums[j], dp[i][j-1]);
                }
            }
        }

//        PrintUtil.printArr(dp);

        return dp[0][len - 1];
    }
}
