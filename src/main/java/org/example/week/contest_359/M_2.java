package org.example.week.contest_359;

import com.google.common.collect.Lists;

import java.util.List;

public class M_2 {

    public Integer result = Integer.MIN_VALUE;

    public int maximizeTheProfit(int n, List<List<Integer>> offers) {

        int[] dp = new int[n];
        recursion(n, offers, 0, dp, 0);

        return result;
    }

    public void recursion(int n, List<List<Integer>> offers, int index, int[] dp, Integer coinNow) {

        result = Math.max(result, coinNow);

        for (int i = index; i < offers.size(); i++) {
            List<Integer> list = offers.get(i);
            Integer start = list.get(0);
            Integer end = list.get(1);
            Integer coin = list.get(2);

            if (canBuy(dp, start, end)) {
                for (int j = start; j <= end; j++) {
                    dp[j] = 1;
                }

                recursion(n, offers, index + 1, dp, coinNow + coin);

                for (int j = start; j <= end; j++) {
                    dp[j] = 0;
                }
            } else {
                recursion(n, offers, index + 1, dp, coinNow);
            }
        }
    }

    public boolean canBuy(int[] dp, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (dp[i] == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        M_2 exe = new M_2();
        List<List<Integer>> arr = Lists.newArrayList(Lists.newArrayList(0, 0, 1), Lists.newArrayList(0, 2, 2), Lists.newArrayList(1, 3, 2));
//        System.out.println(exe.maximizeTheProfit(5, arr));
        List<List<Integer>> arr1 = Lists.newArrayList(Lists.newArrayList(0, 0, 1), Lists.newArrayList(0, 2, 10), Lists.newArrayList(1, 3, 2));
//        System.out.println(exe.maximizeTheProfit(5, arr1));
        List<List<Integer>> arr2 = Lists.newArrayList(
                Lists.newArrayList(0, 0, 5),
                Lists.newArrayList(3, 3, 1),
                Lists.newArrayList(1, 2, 5),
                Lists.newArrayList(0, 0, 7));
        System.out.println(exe.maximizeTheProfit(4, arr2));

        List<List<Integer>> arr3 = Lists.newArrayList(
                Lists.newArrayList(0,6,10),
                Lists.newArrayList(1,2,6),
                Lists.newArrayList(1,3,8),
                Lists.newArrayList(3,5,3),
                Lists.newArrayList(1,4,9),
                Lists.newArrayList(1,8,9),
                Lists.newArrayList(6,6,4),
                Lists.newArrayList(1,2,10));

        System.out.println(exe.maximizeTheProfit(9, arr3));

    }
}
