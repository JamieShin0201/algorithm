package baekjoon.bruteforce;

import java.util.Scanner;

public class _10819_차이를최대로 {

    private static int[] answers;
    private static boolean[] check;
    private static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        answers = new int[N];
        check = new boolean[N];
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        go(numbers, 0);
        System.out.println(max);
    }

    private static void go(int[] numbers, int index) {
        if (index == numbers.length) {
            int total = 0;
            for (int i = 0; i < answers.length - 1; i++) {
                total += Math.abs(answers[i] - answers[i + 1]);
            }
            if (total > max) {
                max = total;
            }
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (check[i]) {
                continue;
            }

            check[i] = true;
            answers[index] = numbers[i];
            go(numbers, index + 1);
            check[i] = false;
        }
    }
}
