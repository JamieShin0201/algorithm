package baekjoon.bruteforce;

import java.util.Scanner;

public class _3085_사탕게임 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = sc.nextLine().toCharArray();
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int nextI = i + 1;
                if (nextI < N) {
                    char tmp = board[i][j];
                    board[i][j] = board[nextI][j];
                    board[nextI][j] = tmp;

                    int newMax = getMaxLength(board);
                    if (max < newMax) {
                        max = newMax;
                    }

                    board[nextI][j] = board[i][j];
                    board[i][j] = tmp;
                }

                int nextJ = j + 1;
                if (nextJ < N) {
                    char tmp = board[i][j];
                    board[i][j] = board[i][nextJ];
                    board[i][nextJ] = tmp;

                    int newMax = getMaxLength(board);
                    if (max < newMax) {
                        max = newMax;
                    }


                    board[i][nextJ] = board[i][j];
                    board[i][j] = tmp;
                }
            }
        }
        System.out.println(max);
    }

    private static int getMaxLength(char[][] board) {
        int max = 0;
        for (int i = 0; i < board.length; i++) {
            int cCount = 1;
            int rCount = 1;
            for (int j = 0; j < board[0].length - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    cCount++;
                } else {
                    cCount = 1;
                }

                if (board[j][i] == board[j + 1][i]) {
                    rCount++;
                } else {
                    rCount = 1;
                }

                if (cCount > max) {
                    max = cCount;
                }

                if (rCount > max) {
                    max = rCount;
                }
            }
        }

        return max;
    }
}
