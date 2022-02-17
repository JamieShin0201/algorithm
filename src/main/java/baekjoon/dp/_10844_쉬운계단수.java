package baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class _10844_쉬운계단수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int mod = 1_000_000_000;
        long[][] counts = new long[N + 1][10];
        for (int i = 1; i <= 9; i++) {
            counts[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j - 1 >= 0) {
                    counts[i][j] += counts[i - 1][j - 1];
                }

                if (j + 1 <= 9) {
                    counts[i][j] += counts[i - 1][j + 1];
                }
                counts[i][j] %= mod;
            }
        }

        long result = Arrays.stream(counts[N]).sum();
        System.out.println(result % mod);
    }
}
