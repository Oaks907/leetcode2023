package org.example.week.contest_361;

public class E_1 {

    public int countSymmetricIntegers(int low, int high) {

        int result = 0;
        for (int i = low; i <= high; i++) {
            if (isValid(i)) {
                result ++;
            }
        }
        return result;
    }

    public boolean isValid(int i) {
        String str = String.valueOf(i);
        if (str.length() % 2 != 0) {
            return false;
        }
        int n = str.length() / 2;

        int sum1 = 0;
        int sum2 = 0;
        for (int j = 0; j < n; j++) {
            sum1 += str.charAt(j);
            sum2 += str.charAt(n + j);
        }

        return sum1 == sum2;
    }

    public static void main(String[] args) {
        E_1 exe = new E_1();
        System.out.println(exe.countSymmetricIntegers(1, 100));
    }
}
