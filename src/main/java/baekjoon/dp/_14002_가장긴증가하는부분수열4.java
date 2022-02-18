package baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class _14002_가장긴증가하는부분수열4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = IntStream.range(0, N)
                .map(i -> sc.nextInt())
                .toArray();

        int[] v = new int[N];
        Arrays.fill(v, -1);
        int[] counts = new int[N];
        Arrays.fill(counts, 1);
        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j] < numbers[i] && counts[i] < counts[j] + 1) {
                    counts[i] = counts[j] + 1;
                    v[i] = j;
                }
            }
        }

        int max = counts[0];
        int p = 0;
        for (int i = 0; i < N; i++) {
            if (max < counts[i]) {
                max = counts[i];
                p = i;
            }
        }
        System.out.println(max);
        go(p, v, numbers);
    }

    private static void go(int p, int[] v, int[] numbers) {
        if (p == -1) {
            return;
        }
        go(v[p], v, numbers);
        System.out.print(numbers[p] + " ");
    }
}
