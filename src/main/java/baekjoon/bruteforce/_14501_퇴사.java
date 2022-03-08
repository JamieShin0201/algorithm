package baekjoon.bruteforce;

import java.util.Scanner;

public class _14501_퇴사 {

    private static int[][] a;
    private static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        a = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            a[i][0] = sc.nextInt();
            a[i][1] = sc.nextInt();
        }

        go(1, 0, N);
        System.out.println(max);
    }

    private static void go(int day, int sum, int maxDay) {
        if (day == maxDay + 1) {
            if (max < sum) {
                max = sum;
            }
            return;
        }
        if (day > maxDay + 1) {
            return;
        }

        go(day + 1, sum, maxDay);
        go(day + a[day][0], sum + a[day][1], maxDay);
    }
}
