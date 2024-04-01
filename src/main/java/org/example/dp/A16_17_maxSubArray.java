package org.example.dp;

import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/21 9:23
 **/
public class A16_17_maxSubArray {

    @Test
    public void test() {

        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        A16_17_maxSubArray exe = new A16_17_maxSubArray();
        System.out.println(exe.maxSubArray(arr));
    }

    public int maxSubArray(int[] nums) {

        int len = nums.length;
        int[] dp = new int[len + 1];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            dp[i + 1] = Math.max(dp[i] + nums[i], nums[i]);
            res = Math.max(res, dp[i + 1]);
        }

//        PrintUtil.printArr(dp);

        return res;
    }
}
