package org.example.dp;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/26 8:17
 **/
public class S509_Fib {

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int f0 = 0;
        int f1 = 1;


        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = f0 + f1;
            f0 = f1;
            f1 = res;
        }
        return res;
    }
}
