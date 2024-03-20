package org.example.dp;

import org.junit.Test;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/5 22:34
 **/
public class A08_01_waysToStep {


    @Test
    public void test() {
        A08_01_waysToStep exe = new A08_01_waysToStep();
        System.out.println(exe.waysToStep(5));
    }

    public int waysToStep(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }

        int n1 = 1;
        int n2 = 2;
        int n3 = 4;
        int res = 0;
        for (int i = 4; i <= n; i++) {
            res = ((n1 + n2) % 1000000007 + n3) % 1000000007;
            n1 = n2;
            n2 = n3;
            n3 = res;
        }
        return res;
    }
}
