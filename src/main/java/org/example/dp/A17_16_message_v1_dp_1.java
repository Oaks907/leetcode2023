package org.example.dp;

import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/21 0:18
 **/
public class A17_16_message_v1_dp_1 {

    @Test
    public void test() {
        int[] arr = {2, 1, 4, 5, 3, 1, 1, 3};
        A17_16_message_v1_dp_1 exe = new A17_16_message_v1_dp_1();
        System.out.println(exe.massage(arr));
    }

    @Test
    public void test1() {
        int[] arr = {2, 1, 1, 2};
        A17_16_message_v2 exe = new A17_16_message_v2();
        System.out.println(exe.massage(arr));
    }

    public int massage(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }


        return dp[len - 1];
    }
}
