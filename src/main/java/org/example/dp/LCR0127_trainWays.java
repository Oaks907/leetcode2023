package org.example.dp;

import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/20 23:34
 **/
public class LCR0127_trainWays {

    @Test
    public void test() {
        LCR0127_trainWays exe = new LCR0127_trainWays();
        System.out.println(exe.trainWays(6));
    }

    public int trainWays(int num) {

        if (num == 0) {
            return 1;
        }

        if (num <= 2) {
            return num;
        }

        int one = 1;
        int two = 2;
        int res = 0;
        for (int i = 3; i <= num; i++) {
            res = (one + two) % 1000000007;
            one = two;
            two = res;
        }

        return res;
    }

}
