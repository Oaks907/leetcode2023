package org.example.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/8 7:28
 **/
public class S0042_Trap_v1 {

    @Test
    public void test() {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        S0042_Trap_v1 exe = new S0042_Trap_v1();
        int result = exe.trap(arr);
        System.out.println(result);
        Assert.assertEquals(6, result);
    }

    @Test
    public void test1() {
        int[] arr = {0};

        S0042_Trap_v1 exe = new S0042_Trap_v1();
        int result = exe.trap(arr);
        System.out.println(result);
    }

    public int trap(int[] height) {

        int length = height.length;
        int[][] dp = new int[2][length];
        dp[0][0] = height[0];
        dp[1][length - 1] = height[length - 1];

        for (int i = 1; i < length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], height[i]);
        }

        for (int i = length - 2; i >= 0; i--) {
            dp[1][i] = Math.max(dp[1][i + 1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < length; i++) {
            res += Math.min(dp[0][i], dp[1][i]) - height[i];
        }

        return res;
    }
}
