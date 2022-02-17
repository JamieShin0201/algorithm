package baekjoon.dp;

import java.util.Scanner;

public class _11727_2xN타일링2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] counts = new int[n + 1];
        counts[0] = 1;
        counts[1] = 1;
        for (int i = 2; i <= n; i++) {
            counts[i] = counts[i - 1] + (2 * counts[i - 2]);
            counts[i] %= 10007;
        }

        System.out.println(counts[n]);
    }
}
