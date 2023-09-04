package org.example.week.contest_360.M_;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class M8021 {

    int result = Integer.MAX_VALUE;

    public int minOperations(List<Integer> nums, int target) {

        result = Integer.MAX_VALUE;

        recursion(nums, target, 0);

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public void recursion(List<Integer> nums, int target, int operatorCount) {

        Integer allSum = nums.stream().reduce(Integer::sum).orElse(0);
        if (allSum < target) {
            return;
        }

        if (recursionIsValid(nums, target, 0, 0)) {
            result = Math.min(operatorCount, result);
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            List<Integer> temp = new ArrayList<>(nums);

            Integer remove = temp.remove(i);
            int val = remove / 2;
            if (val != 0) {
                temp.add(val);
                temp.add(val);
            }
            recursion(temp, target, operatorCount + 1);
        }
    }

    public boolean recursionIsValid(List<Integer> nums, int target, int index, int sum) {
        if (sum > target) {
            return false;
        }

        if (target == sum) {
            return true;
        }

        Integer allSum = nums.stream().reduce(Integer::sum).orElse(0);
        if (allSum < target) {
            return false;
        }

        for (int i1 = index; i1 < nums.size(); i1++) {
            if (recursionIsValid(nums, target, i1 + 1, sum)) {
                return true;
            }
            if (recursionIsValid(nums, target, i1 + 1, sum + nums.get(i1))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        M8021 exe = new M8021();
        int x = exe.minOperations(Lists.newArrayList(1, 2, 8), 7);
        System.out.println(x); // 2

        x = exe.minOperations(Lists.newArrayList(1, 32, 1, 2), 12);
        System.out.println(x); // 2

        x = exe.minOperations(Lists.newArrayList(1, 32, 1), 35);
        System.out.println(x); // 2

    }
}
