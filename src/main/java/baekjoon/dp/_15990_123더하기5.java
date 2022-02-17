package baekjoon.dp;

import java.util.Scanner;

public class _15990_123더하기5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int mod = 1_000_000_009;
        long[][] counts = new long[100001][4];
        counts[1][1] = 1;
        counts[2][2] = 1;
        counts[3][1] = 1;
        counts[3][2] = 1;
        counts[3][3] = 1;
        for (int i = 4; i < 100001; i++) {
            counts[i][1] = counts[i - 1][2] + counts[i - 1][3];
            counts[i][2] = counts[i - 2][1] + counts[i - 2][3];
            counts[i][3] = counts[i - 3][1] + counts[i - 3][2];

            counts[i][1] %= mod;
            counts[i][2] %= mod;
            counts[i][3] %= mod;
        }
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println((counts[n][1] + counts[n][2] + counts[n][3]) % mod);
        }
    }
}
