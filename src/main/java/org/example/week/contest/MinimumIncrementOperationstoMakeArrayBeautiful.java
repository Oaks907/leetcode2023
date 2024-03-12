package org.example.week.contest;

import org.example.util.PrintUtil;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/10/29 11:20
 **/
public class MinimumIncrementOperationstoMakeArrayBeautiful {

    Long minAddCount = Long.MAX_VALUE;

    public long minIncrementOperations(int[] nums, int k) {
        minAddCount = Long.MAX_VALUE;
        recursion(nums, k, 0, 2, 0);
        return minAddCount;
    }

    public void recursion(int[] nums, int k, int from, int to, long addCount) {

        if (addCount > minAddCount) {
            return;
        }

        if (to >= nums.length) {
            minAddCount = Math.min(minAddCount, addCount);
            PrintUtil.printArr(nums);
            System.out.println("current minAddCount:" + minAddCount);
            return;
        }

        boolean existGreatThanK = false;
        for (int i = from; i <= to; i++) {
            if (nums[i] >= k) {
                existGreatThanK = true;
                break;
            }
        }

        if (existGreatThanK) {
            recursion(nums, k, from + 1, to + 1, addCount);
        } else {
            int temp = nums[from];
            nums[from] = k;
            recursion(nums, k, from + 1, to + 1, addCount + (k - temp));
            nums[from] = temp;

            // 递增加在中间
            temp = nums[from + 1];
            nums[from + 1] = k;
            recursion(nums, k, from + 1, to + 1, addCount + (k - temp));
            nums[from + 1] = temp;

            // 递增加在右边
            temp = nums[to];
            nums[to] = k;
            recursion(nums, k, from + 1, to + 1, addCount + (k - temp));
            nums[to] = temp;
        }
    }


    public static void main(String[] args) {
        MinimumIncrementOperationstoMakeArrayBeautiful exe = new MinimumIncrementOperationstoMakeArrayBeautiful();
        int[] arr = {2, 3, 0, 0, 2};
        System.out.println(exe.minIncrementOperations(arr, 4));
        int[] arr1 = {50, 3, 17, 36, 16, 10, 2};
        System.out.println(exe.minIncrementOperations(arr, 19));

        int[] arr2 = {2, 1, 1, 7, 2, 3, 5, 6};
        System.out.println(exe.minIncrementOperations(arr2, 9));
    }
}
