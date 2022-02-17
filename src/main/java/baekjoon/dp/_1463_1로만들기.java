package baekjoon.dp;

import java.util.Scanner;
import java.util.stream.IntStream;

public class _1463_1로만들기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int[] counts = new int[X + 1];

        counts[1] = 0;
        for (int i = 2; i <= X; i++) {
            int case1 = counts[i - 1] + 1;
            int case2 = Integer.MAX_VALUE;
            int case3 = Integer.MAX_VALUE;
            if (i % 3 == 0) {
                case2 = counts[i / 3] + 1;
            }

            if (i % 2 == 0) {
                case3 = counts[i / 2] + 1;
            }

            counts[i] = IntStream.of(case1, case2, case3)
                    .min()
                    .getAsInt();
        }
        System.out.println(counts[X]);
    }
}
