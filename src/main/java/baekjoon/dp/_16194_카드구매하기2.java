package baekjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class _16194_카드구매하기2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] totalPrices = new int[N + 1];
        Arrays.fill(totalPrices, Integer.MAX_VALUE);
        int[] cardPrices = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            cardPrices[i] = sc.nextInt();
        }

        totalPrices[0] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                totalPrices[i] = Math.min(totalPrices[i], totalPrices[i - j] + cardPrices[j]);
            }
        }

        System.out.println(totalPrices[N]);
    }
}
