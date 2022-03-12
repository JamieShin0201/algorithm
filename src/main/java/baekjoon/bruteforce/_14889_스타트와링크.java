package baekjoon.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _14889_스타트와링크 {

    private static int min = Integer.MAX_VALUE;
    private static int[][] MAP;
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        MAP = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                MAP[i][j] = sc.nextInt();
            }
        }

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        System.out.println(go(0, first, second));
    }

    private static int go(int index, List<Integer> first, List<Integer> second) {
        if (index == N) {
            if (first.size() != N / 2) {
                return -1;
            }

            int t1 = 0;
            int t2 = 0;
            for (int i = 0; i < N / 2 - 1; i++) {
                for (int j = i + 1; j < N / 2; j++) {
                    t1 += MAP[first.get(i)][first.get(j)];
                    t1 += MAP[first.get(j)][first.get(i)];
                    t2 += MAP[second.get(i)][second.get(j)];
                    t2 += MAP[second.get(j)][second.get(i)];
                }
            }
            return Math.abs(t1 - t2);
        }

        int ans = -1;
        first.add(index);
        int t1 = go(index + 1, first, second);
        if (ans == -1 || (t1 != -1 && ans > t1)) {
            ans = t1;
        }
        first.remove(first.size() - 1);
        second.add(index);
        int t2 = go(index + 1, first, second);
        if (ans == -1 || (t2 != -1 && ans > t2)) {
            ans = t2;
        }
        second.remove(second.size() - 1);
        return ans;
    }
}
