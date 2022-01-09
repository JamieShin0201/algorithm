package dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChange(coins, 0));
    }

    public static int coinChange(int[] coins, int amount) {
        int[] minAmounts = new int[amount + 1];
        Arrays.fill(minAmounts, amount + 1);

        minAmounts[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    minAmounts[i] = Math.min(minAmounts[i], minAmounts[i - coin] + 1);
                }
            }
        }

        if (minAmounts[amount] == amount + 1) {
            return -1;
        }

        return minAmounts[amount];
    }
}
