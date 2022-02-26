package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _15651_N과M3 {

    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] s = line.split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        numbers = new int[M];

        System.out.print(go(0, M, N));
    }

    private static StringBuilder go(int index, int m, int n) {
        if (index == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(numbers[i] + " ");
            }
            sb.append("\n");
            return sb;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            numbers[index] = i;
            sb.append(go(index + 1, m, n));
        }

        return sb;
    }
}
