package baekjoon.math;

import java.util.Scanner;

public class _1676_팩토리얼0의개수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        for (int i = 5; i <= N; i *= 5) {
            answer += N / i;
        }
        System.out.println(answer);
    }
}
