package baekjoon.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class _2309_일곱난쟁이 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[9];
        for (int i = 0; i < 9; i++) {
            heights[i] = sc.nextInt();
        }

        int total = Arrays.stream(heights).sum();
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (total - heights[i] - heights[j] == 100) {
                    heights[i] = 0;
                    heights[j] = 0;
                    Arrays.stream(heights)
                            .filter(e -> e != 0)
                            .sorted()
                            .forEach(System.out::println);
                    return;
                }
            }
        }
    }
}
