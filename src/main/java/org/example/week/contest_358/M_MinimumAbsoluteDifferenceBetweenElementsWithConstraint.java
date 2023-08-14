package org.example.week.contest_358;

import com.google.common.collect.Lists;

import java.util.*;

public class M_MinimumAbsoluteDifferenceBetweenElementsWithConstraint {

    public int minAbsoluteDifference(List<Integer> nums, int x) {

        int len = nums.size();
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(Integer.MAX_VALUE);
        treeSet.add(Integer.MIN_VALUE);

        int result = Integer.MAX_VALUE;
        for (int i = x; i < len; i++) {
            treeSet.add(nums.get(i - x));
           int val = nums.get(i);
           result = Math.min(result, Math.min(Math.abs(treeSet.floor(val) - val), Math.abs(treeSet.ceiling(val) - val)));
        }
        return result;
    }


    public static void main(String[] args) {
        M_MinimumAbsoluteDifferenceBetweenElementsWithConstraint exe = new M_MinimumAbsoluteDifferenceBetweenElementsWithConstraint();
        System.out.println(exe.minAbsoluteDifference(Lists.newArrayList(5, 3, 2, 10, 15), 1));

        System.out.println(exe.minAbsoluteDifference(Lists.newArrayList(1, 2, 3, 4), 3));

        System.out.println(exe.minAbsoluteDifference(Lists.newArrayList(2, 3, 4, 4), 2));
    }
}
