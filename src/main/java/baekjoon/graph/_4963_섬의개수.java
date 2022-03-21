package baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _4963_섬의개수 {

    private static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    private static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int w = sc.nextInt();
            int h = sc.nextInt();
            if (w == 0 && h == 0) {
                break;
            }

            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int count = 0;
            boolean[][] visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 0 || visited[i][j]) {
                        continue;
                    }
                    bfs(map, i, j, h, w, visited);
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static void bfs(int[][] map, int x, int y, int h, int w, boolean[][] visited) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                    continue;
                }

                if (map[nx][ny] == 0 || visited[nx][ny]) {
                    continue;
                }

                q.add(new Node(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
