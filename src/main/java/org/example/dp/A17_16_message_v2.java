package org.example.dp;

import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/21 0:18
 **/
public class A17_16_message_v2 {

    @Test
    public void test() {
        int[] arr = {2, 1, 4, 5, 3, 1, 1, 3};
        A17_16_message_v2 exe = new A17_16_message_v2();
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
        int temp1 = nums[0];
        int temp2 = nums[1];
        int res = Math.max(temp1, temp2);


        if (len == 2) {
            return res;
        }

        int temp3 = nums[0] + nums[2];
        if (len == 3) {
            return Math.max(temp3, temp2);
        }

        for (int j = 3; j < len; j++) {
            res = Math.max(Math.max(temp2 + nums[j], temp1 + nums[j]), temp3);
            temp1 = temp2;
            temp2 = temp3;
            temp3 = res;
        }

        return res;
    }
}
