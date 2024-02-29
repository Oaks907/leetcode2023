package org.example.depth_first_search;

import java.util.*;

/**
 * @Description
 * @Author Administrator
 * @Date 2024/2/29 8:35
 **/
public class S1971_ValidPath {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            int val0 = edge[0];
            int val1 = edge[1];

            List<Integer> list0 = map.getOrDefault(val0, new ArrayList<>());
            list0.add(val1);
            map.put(val0, list0);

            List<Integer> list1 = map.getOrDefault(val1, new ArrayList<>());
            list1.add(val0);
            map.put(val1, list1);
        }

        Set<Integer> haveUsed = new HashSet<>();
        return findValidPath(map, haveUsed, source, destination, source);
    }

    private boolean findValidPath(Map<Integer, List<Integer>> pathMap, Set<Integer> haveUsed, int source, int destination, int current) {
        if (current == destination) {
            return true;
        }
        if (haveUsed.contains(current)) {
            return false;
        }
        haveUsed.add(current);
        List<Integer> pathList = pathMap.get(current);
        for (Integer node : pathList) {
            boolean valid = this.findValidPath(pathMap, haveUsed, source, destination, node);
            if (valid) {
                return true;
            }
        }
        return false;
    }
}
