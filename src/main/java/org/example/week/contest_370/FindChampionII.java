package org.example.week.contest_370;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/11/5 10:40
 **/
public class FindChampionII {
    public int findChampion(int n, int[][] edges) {
        Set<Integer> set = new HashSet<>();
        int row = edges.length;

        for (int i = 0; i < n; i++) {
            set.add(i);
        }

        for (int i = 0; i < row; i++) {
            int to = edges[i][1];

            set.remove(to);
        }

        if (set.size() == 1) {
            return (Integer) set.toArray()[0];
        } else {
            return -1;
        }
    }
}
