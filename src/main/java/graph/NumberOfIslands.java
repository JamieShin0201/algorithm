package graph;

public class NumberOfIslands {

    private static boolean[][] visited;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }
    
    public static int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int column = grid[0].length;
        visited = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (visited[i][j] || grid[i][j] == '0') {
                    continue;
                }

                count++;
                dfs(grid, i, j);
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int x, int y) {
        int row = grid.length;
        int column = grid[0].length;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= row || ny >= column) {
                continue;
            }

            if (visited[nx][ny] || grid[nx][ny] == '0') {
                continue;
            }

            visited[nx][ny] = true;
            dfs(grid, nx, ny);
        }
    }
}
