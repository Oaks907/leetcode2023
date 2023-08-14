package org.example.week.contest_358;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class contest_358 {
    public int maxSum(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int maxNum = Integer.MIN_VALUE;
            int curNum = nums[i];

            while(curNum != 0) {
                int val = curNum % 10;
                if (val > maxNum) {
                    maxNum = val;
                }
                curNum = curNum / 10;
            }
            List<Integer> list = map.getOrDefault(maxNum, new ArrayList<>());
            list.add(nums[i]);
            map.put(maxNum, list);
        }

        int result = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() < 1) {
                continue;
            }
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (i == j) {
                        continue;
                    }
                    result = Math.max(result, list.get(i) + list.get(j));
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {51,71,17,24,42};
        contest_358 contest358 = new contest_358();
        System.out.println(contest358.maxSum(arr));
    }
}
