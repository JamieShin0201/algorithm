package baekjoon.dp;

import java.util.Scanner;

public class _2193_이친수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] counts = new long[N + 1];

        counts[1] = 1;
        for (int i = 2; i <= N; i++) {
            counts[i] = counts[i - 1] + counts[i - 2];
        }

        System.out.println(counts[N]);
    }
}
