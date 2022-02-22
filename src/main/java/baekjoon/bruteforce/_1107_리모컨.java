package baekjoon.bruteforce;

import java.util.Scanner;

public class _1107_리모컨 {

    private static boolean[] broken = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            broken[sc.nextInt()] = true;
        }

        int answer = N - 100;
        if (answer < 0) {
            answer = -answer;
        }

        for (int i = 0; i <= 1000000; i++) {
            int length = isPossible(i);
            if (length > 0) {
                int pressCount = i - N;
                if (pressCount < 0) {
                    pressCount = -pressCount;
                }

                if (answer > length + pressCount) {
                    answer = length + pressCount;
                }
            }
        }

        System.out.println(answer);
    }

    private static int isPossible(int channel) {
        if (channel == 0) {
            if (broken[0]) {
                return 0;
            } else {
                return 1;
            }
        }

        int length = 0;
        while (channel > 0) {
            if (broken[channel % 10]) {
                return 0;
            }
            length += 1;
            channel /= 10;
        }
        return length;
    }
}
