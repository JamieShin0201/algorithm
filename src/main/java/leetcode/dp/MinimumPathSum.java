package leetcode.dp;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;

        for (int j = 1; j < column; j++) {
            grid[0][j] += grid[0][j - 1];
        }

        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }

        return grid[row - 1][column - 1];
    }
}
