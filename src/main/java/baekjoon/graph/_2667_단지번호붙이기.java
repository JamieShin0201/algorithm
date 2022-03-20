package baekjoon.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _2667_단지번호붙이기 {

    private static int[][] group;
    private static int[][] map;
    private static int N;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.nextLine();

        group = new int[N][N];
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && group[i][j] == 0) {
                    count++;
                    bfs(i, j, count);
                }
            }
        }

        int[] answers = new int[count];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (group[i][j] != 0) {
                    answers[group[i][j] - 1] += 1;
                }
            }
        }

        Arrays.sort(answers);
        System.out.println(count);
        Arrays.stream(answers)
                .forEach(System.out::println);
    }

    private static void bfs(int x, int y, int count) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        group[x][y] = count;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= N || ny >= N || nx < 0 || ny < 0) {
                    continue;
                }

                if (map[nx][ny] == 1 && group[nx][ny] == 0) {
                    q.offer(new Node(nx, ny));
                    group[nx][ny] = count;
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
