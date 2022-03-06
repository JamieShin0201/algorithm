package baekjoon.bruteforce;

import java.util.Scanner;

public class _6603_로또 {

    private static int N;
    private static int[] lotto;
    private static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            N = sc.nextInt();
            if (N == 0) {
                return;
            }
            lotto = new int[N];
            check = new boolean[N];
            for (int i = 0; i < N; i++) {
                lotto[i] = sc.nextInt();
            }
            combination(0, 0);
            System.out.println();
        }
    }

    private static void combination(int index, int count) {
        if (count == 6) {
            for (int i = 0; i < N; i++) {
                if (check[i]) {
                    System.out.print(lotto[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = index; i < N; i++) {
            check[i] = true;
            combination(i + 1, count + 1);
            check[i] = false;
        }
    }
}
