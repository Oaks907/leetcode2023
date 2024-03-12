package org.example.dp;

import org.example.util.PrintUtil;
import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/3/12 15:19
 */
public class CanJump {

    @Test
    public void test() {

        int[] arr = {2, 3, 1, 1, 6};
        CanJump exe = new CanJump();
        System.out.println(exe.canJump(arr));
    }

    @Test
    public void test1() {

        int[] arr = {4, 2, 1, 0, 0, 6};
        CanJump exe = new CanJump();
        System.out.println(exe.canJump(arr));
    }

    private boolean canJump(int[] arr) {
        int len = arr.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;

        for (int i = 1; i < len; i++) {
            for (int m = 0; m < i; m++) {
                if (dp[m] && m + arr[m] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }

        PrintUtil.printArr(dp);
        return dp[len - 1];
    }

}
