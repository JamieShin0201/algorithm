package baekjoon.math;

import java.util.Arrays;
import java.util.Scanner;

public class _1978_소수찾기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        long count = Arrays.stream(numbers)
                .filter(n -> isPrime(n))
                .count();
        System.out.println(count);
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
