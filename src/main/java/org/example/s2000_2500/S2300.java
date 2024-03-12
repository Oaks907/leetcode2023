package org.example.s2000_2500;

import org.example.util.PrintUtil;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/solutions/2477429/zhou-yu-he-yao-shui-de-cheng-gong-dui-sh-a22z/?envType=daily-question&envId=2023-11-10
 *
 * @Description
 * @Author Administrator
 * @Date 2023/11/10 7:44
 **/
public class S2300 {

    /**
     * 二分法
     *
     * @param spells
     * @param potions
     * @param success
     * @return
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);
        int[] result = new int[spells.length];
        int n = spells.length;
        int m = potions.length;
        for (int i = 0; i < n; i++) {
            long t = (success + spells[i] - 1) / spells[i] - 1;
            result[i] = m - binarySearch(potions, 0, m - 1, t);
        }

        return result;
    }

    public int binarySearch(int[] arr, int low, int high, long target) {
        int res = high + 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    /**
     * 双指针解法
     *
     * @param spells
     * @param potions
     * @param success
     * @return
     */
    public int[] successfulPairs_2(int[] spells, int[] potions, long success) {

        int[] result = new int[spells.length];
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        for (int i = 0, j = m - 1; i < j; ++i, --j) {
            int temp = potions[i];
            potions[i] = potions[j];
            potions[j] = temp;
        }

        // 记录 Spells
        int[][] idx = new int[n][2];
        for (int i = 0; i < n; i++) {
            idx[i][0] = spells[i];
            idx[i][1] = i;
        }

        Arrays.sort(idx, Comparator.comparingInt(a -> a[0]));

        for (int i = 0, j = 0; i < n; i++) {
            int index = idx[i][1];
            int v = idx[i][0];
            while (j < m && v * (long) potions[j] >= success) {
                ++j;
            }
            result[index] = j;
        }
        return result;
    }

    @Test
    public void case_1() {
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        int success = 7;

        PrintUtil.printArr(successfulPairs(spells, potions, success));
        PrintUtil.printArr(successfulPairs_2(spells, potions, success));
    }


}
