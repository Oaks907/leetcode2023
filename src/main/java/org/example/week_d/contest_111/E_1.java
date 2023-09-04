package org.example.week_d.contest_111;

import java.util.Arrays;
import java.util.List;

public class E_1 {

    public int countPairs(List<Integer> nums, int target) {
        int result = 0;

        for(int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    result++;
                }
            }
        }
        return result;
    }
}
