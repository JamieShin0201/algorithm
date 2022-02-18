package baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class _1912_연속합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int value = numbers[i] + numbers[i - 1];
            if (value > numbers[i]) {
                numbers[i] = value;
            }
        }

        int max = Arrays.stream(numbers).max().getAsInt();
        System.out.println(max);
    }
}
