package baekjoon.bruteforce;

import java.util.Scanner;

public class _10974_모든순열 {

    private static int[] answers;
    private static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        answers = new int[N];
        check = new boolean[N];
        go(N, 0);
    }

    private static void go(int n, int index) {
        if (n == index) {
            for (int i = 0; i < n; i++) {
                System.out.print(answers[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check[i]) {
                continue;
            }

            check[i] = true;
            answers[index] = i + 1;
            go(n, index + 1);
            check[i] = false;
        }
    }
}
