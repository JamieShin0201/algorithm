package baekjoon.bruteforce;

import java.util.Scanner;

public class _1476_날짜계산 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int E = sc.nextInt() - 1;
        int S = sc.nextInt() - 1;
        int M = sc.nextInt() - 1;

        int totalCount = 0;
        while (!(totalCount % 15 == E && totalCount % 28 == S && totalCount % 19 == M)) {
            totalCount++;
        }

        System.out.println(totalCount + 1);
    }
}
