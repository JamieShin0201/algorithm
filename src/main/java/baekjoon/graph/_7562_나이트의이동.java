package baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _7562_나이트의이동 {

    private static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int i = sc.nextInt();
            int[][] map = new int[i][i];

            int currentX = sc.nextInt();
            int currentY = sc.nextInt();

            int targetX = sc.nextInt();
            int targetY = sc.nextInt();

            bfs(map, currentX, currentY);
            System.out.println(map[targetX][targetY] - 1);
        }
    }

    private static void bfs(int[][] map, int currentX, int currentY) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(currentX, currentY));
        map[currentX][currentY] = 1;

        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length) {
                    continue;
                }

                if (map[nx][ny] != 0) {
                    continue;
                }

                map[nx][ny] = map[now.x][now.y] + 1;
                q.add(new Node(nx, ny));
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
