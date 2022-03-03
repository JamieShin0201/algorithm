package baekjoon.bruteforce;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class _15663_N과M9 {

    private static int[] numbers;
    private static int[] answers;
    private static boolean[] check;
    private static LinkedHashSet<String> resultSet;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        resultSet = new LinkedHashSet<>();
        answers = new int[M];
        check = new boolean[N];
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);
        go(N, M, 0);
        resultSet.stream().forEach(System.out::println);
    }

    private static void go(int n, int m, int index) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(answers[i] + " ");
            }
            resultSet.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            answers[index] = numbers[i];
            go(n, m, index + 1);
            check[i] = false;
        }
    }
}
