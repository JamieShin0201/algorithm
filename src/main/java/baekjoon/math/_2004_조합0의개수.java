package baekjoon.math;

import java.util.Scanner;

public class _2004_조합0의개수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int two = 0;
        int five = 0;

        for (long i = 2; i <= n; i *= 2) {
            two += n / i;
        }
        for (long i = 2; i <= n - m; i *= 2) {
            two -= (n - m) / i;
        }
        for (long i = 2; i <= m; i *= 2) {
            two -= m / i;
        }
        for (long i = 5; i <= n; i *= 5) {
            five += n / i;
        }
        for (long i = 5; i <= n - m; i *= 5) {
            five -= (n - m) / i;
        }
        for (long i = 5; i <= m; i *= 5) {
            five -= m / i;
        }

        System.out.println(Math.min(two, five));
    }
}
