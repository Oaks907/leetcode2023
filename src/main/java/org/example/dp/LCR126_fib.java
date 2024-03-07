package org.example.dp;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/5 22:27
 **/
public class LCR126_fib {



    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int n1 = 0;
        int n2 = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (n1 + n2) % 1000000007;
            n1 = n2;
            n2 = res;
        }
        return res;
    }
}
