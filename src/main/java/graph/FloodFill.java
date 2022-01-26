package graph;

import java.util.*;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        floodFillDFS(image, 1, 1, 1);
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public static void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        image[sr][sc] = newColor;

        int row = image.length;
        int column = image[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};


        for (int i = 0; i < 4; i++) {
            int nx = sr + dx[i];
            int ny = sc + dy[i];

            if (nx < 0 || ny < 0 || nx >= row || ny >= column) {
                continue;
            }

            if (image[nx][ny] != oldColor || image[nx][ny] == newColor) {
                continue;
            }

            dfs(image, nx, ny, oldColor, newColor);
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int row = image.length;
        int column = image[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int value = image[sr][sc];

        Set<Point> visited = new HashSet<>();
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(sr, sc));
        while (!q.isEmpty()) {
            Point p = q.poll();
            image[p.x][p.y] = newColor;
            visited.add(p);

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= row || ny >= column) {
                    continue;
                }

                Point nextP = new Point(nx, ny);
                if (visited.contains(nextP) || image[nx][ny] != value) {
                    continue;
                }
                image[nx][ny] = newColor;
                q.offer(nextP);
            }
        }

        return image;
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
