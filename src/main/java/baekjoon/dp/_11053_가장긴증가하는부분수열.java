package baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class _11053_가장긴증가하는부분수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] counts = new int[N];
        Arrays.fill(counts, 1);

        int[] numbers = IntStream.range(0, N)
                .map(i -> sc.nextInt())
                .toArray();


        for (int i = 1; i < N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[j] < numbers[i]) {
                    counts[i] = Math.max(counts[i], counts[j] + 1);
                }
            }
        }

        int max = Arrays.stream(counts).max().getAsInt();
        System.out.println(max);
    }
}
