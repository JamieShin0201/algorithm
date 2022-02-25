package baekjoon.bruteforce;

import java.util.Scanner;

public class _15650_N과M2 {

    private static boolean[] check;
    private static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        check = new boolean[N + 1];
        numbers = new int[M];

        go(0, M, N, 0);
    }

    private static void go(int index, int m, int n, int row) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = row + 1; i <= n; i++) {
            if (!check[i]) {
                check[i] = true;
                numbers[index] = i;
                go(index + 1, m, n, i);
                check[i] = false;
            }
        }
    }
}
