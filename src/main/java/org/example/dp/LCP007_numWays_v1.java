package org.example.dp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/3/6 7:55
 **/
public class LCP007_numWays_v1 {

    @Test
    public void test() {

        int[][] arr = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};

        LCP007_numWays_v1 exe = new LCP007_numWays_v1();
        System.out.println(exe.numWays(5, arr, 3));
    }

    public int numWays(int n, int[][] relation, int k) {
        int row = relation.length;

        Map<Integer, List<Integer>> pathMap = new HashMap<>();
        for (int i = 0; i < row; i++) {
            int start = relation[i][0];
            int end = relation[i][1];
            List<Integer> orDefault = pathMap.getOrDefault(start, new ArrayList<>());
            orDefault.add(end);
            pathMap.put(start, orDefault);
        }

        return recursion(0, n - 1, pathMap, k, 0);
    }

    private Integer recursion(int current, int target, Map<Integer, List<Integer>> pathMap, int targetStep, int currentStep) {
        if (current == target && currentStep == targetStep) {
            return 1;
        }
        if (currentStep >= targetStep) {
            return 0;
        }

        List<Integer> list = pathMap.getOrDefault(current, new ArrayList<>());
        int path = 0;
        for (int i = 0; i < list.size(); i++) {
            path += recursion(list.get(i), target, pathMap, targetStep, currentStep + 1);
        }
        return path;
    }
}
