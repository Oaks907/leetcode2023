package org.example.s0000_1000;

import org.example.util.PrintUtil;
import org.junit.Test;

/**
 *
 */
public class S0338_CountingBits {

    @Test
    public void test() {
        S0338_CountingBits exe = new S0338_CountingBits();
        PrintUtil.printArr(exe.countBits(16));
    }


    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        int x = 1;

        for (int i = 1; i <= n; i++) {
            if (x == i) {
                arr[i] = 1;
                x = x * 2;
            } else {
                arr[i] = arr[i - x / 2] + 1;
            }
        }
        return arr;
    }
}
