package org.example.dp;

import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/20 8:59
 **/
public class A05_03_reverseBits_v1 {

    @Test
    public void test() {
        A05_03_reverseBits_v1 exe = new A05_03_reverseBits_v1();
        System.out.println(exe.reverseBits(1775));
    }

    public int reverseBits(int num) {
        int max = 0;
        int reverse = 0;
        int current = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & 1) == 1) {
                current++;
                reverse++;
            } else {
                reverse = current + 1;
                current = 0;
            }
            if (reverse > max) max = reverse;
            num >>= 1;
        }
        return max;
    }
}
