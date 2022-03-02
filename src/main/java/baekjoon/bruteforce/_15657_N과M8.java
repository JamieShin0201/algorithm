package baekjoon.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class _15657_N과M8 {

    private static int[] numbers;
    private static int[] answers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        answers = new int[M];
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);

        go(N, M, 0, 0);
    }

    private static void go(int n, int m, int index, int before) {
        if (m == index) {
            for (int i = 0; i < m; i++) {
                System.out.print(answers[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = before; i < n; i++) {
            answers[index] = numbers[i];
            go(n, m, index + 1, i);
        }
    }
}
