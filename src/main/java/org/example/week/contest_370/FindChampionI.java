package org.example.week.contest_370;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author Administrator
 * @Date 2023/11/5 10:31
 **/
public class FindChampionI {

    public int findChampion(int[][] grid) {
        Set<Integer> set = new HashSet<>();
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            set.add(i);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    set.remove(j);
                }
            }
        }

            return (Integer) set.toArray()[0];
    }
}
