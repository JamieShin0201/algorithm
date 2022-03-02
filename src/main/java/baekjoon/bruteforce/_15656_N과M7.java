package baekjoon.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class _15656_N과M7 {

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
        System.out.println(go(N, M, 0));
    }

    private static StringBuilder go(int n, int m, int index) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(answers[i] + " ");
            }
            sb.append("\n");
            return sb;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answers[index] = numbers[i];
            sb.append(go(n, m, index + 1));
        }
        return sb;
    }
}
