package baekjoon.dp;

import java.util.Scanner;

public class _9095_123더하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int[] counts = new int[11];
        counts[1] = 1;
        counts[2] = 2;
        counts[3] = 4;
        for (int i = 4; i < 11; i++) {
            counts[i] = counts[i - 1] + counts[i - 2] + counts[i - 3];
        }
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            System.out.println(counts[n]);
        }
    }
}
