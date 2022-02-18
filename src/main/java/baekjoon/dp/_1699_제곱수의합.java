package baekjoon.dp;

import java.util.Scanner;

public class _1699_제곱수의합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] counts = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            counts[i] = i;
            for (int j = 1; j * j <= i; j++) {
                int value = counts[i - j * j] + 1;
                if (counts[i] > value) {
                    counts[i] = value;
                }
            }
        }

        System.out.println(counts[N]);
    }
}
