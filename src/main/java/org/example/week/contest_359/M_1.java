package org.example.week.contest_359;

import org.example.util.PrintUtil;

import java.util.HashSet;
import java.util.Set;

public class M_1 {

    public int minimumSum(int n, int k) {
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        int index = 1;
        while (n > 0) {
            if (set.contains(k - index)) {
                index++;
            } else {
                set.add(index);
                result += index;
                n--;
                index++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        M_1 exe = new M_1();
        System.out.println(exe.minimumSum(5, 4));
    }
}
