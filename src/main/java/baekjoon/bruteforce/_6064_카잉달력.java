package baekjoon.bruteforce;

import java.util.Scanner;

public class _6064_카잉달력 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            boolean ok = false;
            for (int j = x; j < (N * M); j += M) {
                if (j % N == y) {
                    System.out.println(j + 1);
                    ok = true;
                    break;
                }
            }

            if (!ok) {
                System.out.println(-1);
            }
        }
    }
}
