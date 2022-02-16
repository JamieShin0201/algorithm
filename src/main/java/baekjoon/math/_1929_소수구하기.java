package baekjoon.math;

import java.util.Scanner;

public class _1929_소수구하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        boolean[] check = new boolean[N + 1];
        check[0] = true;
        check[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (check[i]) {
                continue;
            }

            for (int j = i + i; j < N; j += i) {
                check[j] = true;
            }
        }
        for (int i = M; i <= N; i++) {
            if (!check[i]) {
                System.out.println(i);
            }
        }
    }
}
