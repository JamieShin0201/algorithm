package baekjoon.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class _15666_N과M12 {

    private static int[] answers;
    private static int[] numbers;

    static StringBuilder go(int index, int start, int n, int m) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(answers[i] + " ");
            }
            sb.append("\n");
            return sb;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i < n; i++) {
            answers[index] = numbers[i];
            sb.append(go(index + 1, i, n, m));
        }
        return sb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        answers = new int[m];
        numbers = new int[n];
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = sc.nextInt();
        }
        Arrays.sort(temp);
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && temp[i] == temp[i - 1]) {
                continue;
            }
            numbers[k++] = temp[i];
        }
        n = k;
        System.out.println(go(0, 0, n, m));
    }
}
