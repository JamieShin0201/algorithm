package baekjoon.bruteforce;

import java.util.Scanner;

public class _15652_N과M4 {

    private static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        numbers = new int[M];
        go(0, N, M, 1);
    }

    private static void go(int index, int n, int m, int start) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            numbers[index] = i;
            go(index + 1, n, m, i);
        }
    }
}
