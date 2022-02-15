package baekjoon.math;

import java.util.Scanner;

public class _2609_최대공약수와최소공배수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        System.out.println(getGCD(x, y));
        System.out.println(getLCM(x, y));
    }

    private static int getGCD(int x, int y) {
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }

    private static int getLCM(int x, int y) {
        int gcd = getGCD(x, y);
        return gcd * (x / gcd) * (y / gcd);
    }
}
