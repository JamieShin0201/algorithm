package baekjoon.dp;

import java.util.Scanner;

public class _11052_카드구매하기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] totalPrices = new int[N + 1];
        int[] cardPrices = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            cardPrices[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                totalPrices[i] = Math.max(totalPrices[i], totalPrices[i - j] + cardPrices[j]);
            }
        }

        System.out.println(totalPrices[N]);
    }
}
