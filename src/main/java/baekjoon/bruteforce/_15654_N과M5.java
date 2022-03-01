package baekjoon.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class _15654_N과M5 {
    private static int[] numbers;
    private static int[] a;
    private static boolean[] c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        a = new int[m];
        c = new boolean[n];
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);
        go(n, m, 0);
    }

    private static void go(int n, int m, int index) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!c[i]) {
                c[i] = true;
                a[index] = numbers[i];
                go(n, m, index + 1);
                c[i] = false;
            }
        }
    }
}
