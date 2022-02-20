package baekjoon.dp;

import java.util.Scanner;

public class _2225_합분해 {

    private static final int MODE = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long[][] counts = new long[K + 1][N + 1];
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                counts[i][j] = counts[i - 1][j];
                if (j > 0) {
                    counts[i][j] += counts[i][j - 1];
                }
                counts[i][j] %= MODE;
            }
        }
        System.out.println(counts[K][N]);
    }
}
