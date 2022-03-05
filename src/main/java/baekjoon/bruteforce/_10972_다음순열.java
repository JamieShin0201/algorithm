package baekjoon.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class _10972_다음순열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        int x = -1;
        int y = -1;
        for (int i = N - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                x = i - 1;
                break;
            }
        }

        if (x == -1) {
            System.out.println("-1");
            return;
        }

        for (int i = N - 1; i >= 0; i--) {
            if (numbers[x] < numbers[i]) {
                y = i;
                break;
            }
        }
        
        swap(numbers, x, y);
        reverse(numbers, x, y);
        for (int i = 0; i < N; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    private static void swap(int[] numbers, int x, int y) {
        int temp = numbers[x];
        numbers[x] = numbers[y];
        numbers[y] = temp;
    }

    private static void reverse(int[] numbers, int x, int y) {
        int[] temp = Arrays.copyOf(numbers, numbers.length);
        int count = 1;
        for (int i = x + 1; i < numbers.length; i++) {
            numbers[i] = temp[numbers.length - count];
            count++;
        }
    }
}
