package org.example.week.contest_370;

import java.util.*;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/11/5 10:54
 **/
public class MaximumScoreAfterApplyingOperationsTree {


    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int row = edges.length;
        int col = edges[0].length;

        for (int i = 0; i < row; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            List<Integer> orDefault = map.getOrDefault(from, new ArrayList<>());
            orDefault.add(to);
            map.put(from, orDefault);
        }

        maxScore = recursion(values, map, 0);

        return maxScore;
    }

    Long maxScore = Long.MIN_VALUE;

    public Long recursion(int[] values, Map<Integer, List<Integer>> map, Integer curN) {

        if (!map.containsKey(curN)) {
            return 0L;
        }
        List<Integer> list = map.get(curN);
        // 选当前curN
        Long notChooseCurNSocre = 0L;
        for (int i = 0; i < list.size(); i++) {
            notChooseCurNSocre += recursion(values, map, list.get(i));
        }

        // 不选当前curN
        Long score = rec(values, map, list);
        return Math.max(score, values[curN] + notChooseCurNSocre);
    }

    public Long rec(int[] values, Map<Integer, List<Integer>> map, List<Integer> list) {
        if (list.size() == 0) {
            return 0L;
        }
        Long returnVal = 0L;
        for (Integer integer : list) {
            returnVal += values[integer];
            returnVal += rec(values, map, map.getOrDefault(integer, new ArrayList<>()));
        }
        return  returnVal;
    }

    public static void main(String[] args) {
        MaximumScoreAfterApplyingOperationsTree exec = new MaximumScoreAfterApplyingOperationsTree();

//        int[][] edges = {{0,1},{0,2},{0,3},{2,4},{4,5}};
//        int[] arr = {5,2,5,2,1,1};
//
//        System.out.println(exec.maximumScoreAfterOperations(edges, arr));



        int[][] arr1 = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}};
        int[] arr2 = {20,10,9,7,4,3,5};

        System.out.println(exec.maximumScoreAfterOperations(arr1, arr2));
    }

}
