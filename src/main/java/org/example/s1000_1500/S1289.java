package org.example.s1000_1500;

public class S1289 {

    public int minFallingPathSum(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {

                int curVal = Integer.MAX_VALUE;

                for (int k = 0; k < col; k++) {
                    if (k != j) {
                        curVal = Math.min(curVal, grid[i][j] + grid[i - 1][k]);
                    }
                }

                grid[i][j] = curVal;
            }
        }

        int result = grid[row - 1][0];
        for (int i = 1; i < col; i++) {
            result = Math.min(result, grid[row - 1][i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {1, 2}, {1, 2}};
        S1289 a = new S1289();
        System.out.println(a.minFallingPathSum(arr));

        int[][] arr1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(a.minFallingPathSum(arr1));
    }
}
