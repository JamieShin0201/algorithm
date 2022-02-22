package baekjoon.bruteforce;

import java.util.Scanner;

public class _14500_테트로미노 {

    private static int N;
    private static int M;
    private static int[][] board;
    private static boolean[][] check;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int max;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        check = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                check[i][j] = true;
                go(i, j, board[i][j], 1);
                check[i][j] = false;
            }
        }

        System.out.println(max);
    }

    public static void go(int x, int y, int total, int depth) {
        if (depth == 4) {
            if (total > max) {
                max = total;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                continue;
            }

            if (check[nextX][nextY]) {
                continue;
            }

            check[nextX][nextY] = true;
            go(nextX, nextY, total + board[nextX][nextY], depth + 1);

            if (depth == 2) {
                for (int j = 0; j < 4; j++) {
                    int nextX2 = x + dx[j];
                    int nextY2 = y + dy[j];

                    if (nextX2 < 0 || nextY2 < 0 || nextX2 >= N || nextY2 >= M) {
                        continue;
                    }

                    if (check[nextX2][nextY2]) {
                        continue;
                    }

                    check[nextX2][nextY2] = true;
                    go(nextX2, nextY2, total + board[nextX][nextY] + board[nextX2][nextY2], depth + 2);
                    check[nextX2][nextY2] = false;
                }
            }

            check[nextX][nextY] = false;
        }
    }
}
