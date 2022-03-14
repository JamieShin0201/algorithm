package baekjoon.bruteforce;

import java.util.Scanner;

public class _1248_맞춰봐 {

    private static int n;
    private static int[][] sign;
    private static int[] ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ans = new int[n];
        sign = new int[n][n];
        String s = sc.next();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                char c = s.charAt(cnt);
                if (c == '0') {
                    sign[i][j] = 0;
                } else if (c == '+') {
                    sign[i][j] = 1;
                } else {
                    sign[i][j] = -1;
                }
                cnt += 1;
            }
        }

        go(0);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    private static boolean go(int index) {
        if (n == index) {
            return true;
        }

        if (sign[index][index] == 0) {
            ans[index] = 0;
            return ok(index) && go(index + 1);
        }

        for (int i = 1; i <= 10; i++) {
            ans[index] = sign[index][index] * i;
            if (ok(index) && go(index + 1)) {
                return true;
            }
        }

        return false;
    }

    private static boolean ok(int index) {
        int sum = 0;
        for (int i = index; i >= 0; i--) {
            sum += ans[i];
            if (sign[i][index] == 0) {
                if (sum != 0) {
                    return false;
                }
            } else if (sign[i][index] > 0) {
                if (sum <= 0) {
                    return false;
                }
            } else if (sign[i][index] < 0) {
                if (sum >= 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
