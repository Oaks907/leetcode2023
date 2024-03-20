package org.example.dp;

import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/21 0:18
 **/
public class A17_16_message_v2_1 {

    @Test
    public void test() {
        int[] arr = {2, 1, 4, 5, 3, 1, 1, 3};
        A17_16_message_v2_1 exe = new A17_16_message_v2_1();
        System.out.println(exe.massage(arr));
    }

    @Test
    public void test1() {
        int[] arr = {2, 1, 1, 2};
        A17_16_message_v2_1 exe = new A17_16_message_v2_1();
        System.out.println(exe.massage(arr));
    }

    public int massage(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            int c = Math.max(b, a + nums[i]);
            a = b;
            b = c;
        }
        return b;
    }
}
