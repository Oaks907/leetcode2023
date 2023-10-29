package org.example.week.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/10/29 10:37
 **/
public class FindtheKofArray {

    public int findKOr(int[] nums, int k) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int index = 0;

            while(val != 0) {
                if ((val & 1) == 1) {
                    List<Integer> orDefault = map.getOrDefault(index, new ArrayList<>());
                    orDefault.add(i);
                    map.put(index, orDefault);
                }

                val = val >> 1;
                index++;
            }
        }

        int result = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            if (list.size() >= k) {
                result += Math.pow(2,entry.getKey());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindtheKofArray exe = new FindtheKofArray();
        int[] arr = {7,12,9,8,9,15};
        System.out.println(exe.findKOr(arr, 4));
    }
}
