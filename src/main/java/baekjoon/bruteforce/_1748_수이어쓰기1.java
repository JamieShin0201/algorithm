package baekjoon.bruteforce;

import java.util.Scanner;

public class _1748_수이어쓰기1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long count = 0;
        int length = 1;
        for (int start = 1; start <= N; start *= 10) {
            int end = (start * 10) - 1;
            if (end > N) {
                end = N;
            }
            count += (long) (end - start + 1) * length;
            length++;
        }

        System.out.println(count);
    }
}
