package baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2178_미로탐색 {

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(map, N, M);
        System.out.println(map[N - 1][M - 1]);
    }

    private static void bfs(int[][] map, int n, int m) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 1) {
                    q.add(new Node(nx, ny));
                    map[nx][ny] = map[now.x][now.y] + 1;
                }
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
