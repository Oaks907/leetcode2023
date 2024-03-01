package org.example.dp;

import org.junit.Test;

/**
 * @Description:
 * @Author: lihaifei04
 * @Date: 2024/2/29 19:09
 */
public class MaxMultiplyChildrenArray_v4 {

    @Test
    public void test() {

        int[] arr = {-2, 1, -3, 1, -1, 6, 2, -5, 4};

        MaxMultiplyChildrenArray_v4 exe = new MaxMultiplyChildrenArray_v4();

        System.out.println(exe.maxMultiplyChildrenArray(arr));
    }

    public int maxMultiplyChildrenArray(int[] arr) {
        int maxVal = arr[0];
        int minVal = arr[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];
            int max = maxVal;
            int min = minVal;
            maxVal = Math.max(Math.max(max * val, min * val), val);
            minVal = Math.min(Math.min(max * val, min * val), val);
            ans = Math.max(maxVal, ans);
        }
        return ans;
    }
}
