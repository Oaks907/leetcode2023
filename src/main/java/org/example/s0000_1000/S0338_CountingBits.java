package org.example.s0000_1000;

/**
 *
 */
public class S0338_CountingBits {


    public int[] countBits(int n) {
        if (n == 0) {
            return new int[]{};
        }

        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                arr[i] = 1;
            } else {
                arr[i] = (i % 2 == 0) ? arr[i - 1] : arr[i - 1] + 1;
            }
        }

        return arr;
    }
}
