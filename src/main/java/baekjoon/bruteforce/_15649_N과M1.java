package baekjoon.bruteforce;

import java.util.Scanner;

public class _15649_N과M1 {

    private static boolean[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m];
        check = new boolean[n + 1];
        go(n, m, 0, a);
    }

    private static void go(int n, int m, int count, int[] a) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!check[i]) {
                check[i] = true;
                a[count] = i;
                go(n, m, count + 1, a);
                check[i] = false;
            }
        }
    }
}
