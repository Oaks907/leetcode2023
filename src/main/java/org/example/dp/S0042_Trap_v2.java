package org.example.dp;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/8 7:28
 **/
public class S0042_Trap_v2 {

    @Test
    public void test() {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        S0042_Trap_v2 exe = new S0042_Trap_v2();
        int result = exe.trap(arr);
        System.out.println(result);
        Assert.assertEquals(6, result);
    }

    @Test
    public void test1() {
        int[] arr = {0};

        S0042_Trap_v2 exe = new S0042_Trap_v2();
        int result = exe.trap(arr);
        System.out.println(result);
    }

    public int trap(int[] height) {

        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        int ans = 0;

        while(left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if (height[left] < height[right]) {
                ans += leftMax - height[left];
                left++;
            } else if (height[right] <= rightMax) {
                ans += rightMax - height[right];
                right --;
            }

        }

        return ans;
    }
}
