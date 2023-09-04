package org.example.week.contest_360.M_;

import java.util.HashSet;
import java.util.Set;

public class FindMinimumPossibleSumofBeautifulArray {

    public long minimumPossibleSum(int n, int target) {
        int result = 0;
        int count = 0;
        int i = 1;
        Set<Integer> set = new HashSet<>();
        while (count < n) {
            int val = i;
            if (set.contains(target - i)) {
                i++;
                continue;
            } else {
                result += val;
                i++;
                count++;
                set.add(val);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindMinimumPossibleSumofBeautifulArray exe = new FindMinimumPossibleSumofBeautifulArray();
        System.out.println(exe.minimumPossibleSum(2, 3));
        System.out.println(exe.minimumPossibleSum(3, 3));
        System.out.println(exe.minimumPossibleSum(1, 1));
    }
}
