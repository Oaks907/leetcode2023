package org.example.dp;

import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/11 16:52
 */
public class MaxSubArray_v1 {


    @Test
    public void test() {
        int[] arr = {-2, 1, -3, 4, -1, 3, -5, 1, 2};
        MaxSubArray_v1 exe = new MaxSubArray_v1();
        System.out.println(exe.maxSubArray(arr));
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(dp[i], max);
        }

        PrintUtil.printIntArr(dp);

        return max;
    }
}
