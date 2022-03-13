package baekjoon.bruteforce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _2529_부등호 {

    private static int k;
    private static char[] inputs = new char[20];
    private static List<String> ans = new ArrayList<>();
    private static boolean[] check = new boolean[10];


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            inputs[i] = sc.next().toCharArray()[0];
        }

        go(0, "");

        Collections.sort(ans);

        int m = ans.size();
        System.out.println(ans.get(m - 1));
        System.out.println(ans.get(0));
    }

    private static boolean ok(String num) {
        for (int i = 0; i < k; i++) {
            if (inputs[i] == '<') {
                if (num.charAt(i) > num.charAt(i + 1)) {
                    return false;
                }
            } else if (inputs[i] == '>') {
                if (num.charAt(i) < num.charAt(i + 1)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void go(int index, String num) {
        if (index == k + 1) {
            if (ok(num)) {
                ans.add(num);
            }
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            go(index + 1, num + i);
            check[i] = false;
        }
    }
}
