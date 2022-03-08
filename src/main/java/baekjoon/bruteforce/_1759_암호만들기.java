package baekjoon.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class _1759_암호만들기 {

    private static String[] alphabets;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int C = sc.nextInt();

        alphabets = new String[C];
        for (int i = 0; i < C; i++) {
            alphabets[i] = sc.next();
        }
        Arrays.sort(alphabets);
        System.out.println(go("", 0, L));
    }

    private static StringBuilder go(String secret, int before, int length) {
        if (secret.length() == length && isValid(secret)) {
            return new StringBuilder(secret + "\n");
        }

        if (secret.length() > length) {
            return new StringBuilder();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = before; i < alphabets.length; i++) {
            sb.append(go(secret + alphabets[i], i + 1, length));
        }

        return sb;
    }

    private static boolean isValid(String secret) {
        int jaCount = 0;
        int moCount = 0;
        for (char c : secret.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                moCount++;
            } else {
                jaCount++;
            }
        }

        if (jaCount >= 2 && moCount >= 1) {
            return true;
        }
        return false;
    }
}
