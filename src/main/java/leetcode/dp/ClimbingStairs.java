package leetcode.dp;

public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
    }

    public static int climbStairs(int n) {
        int[] results = new int[n + 1];
        results[0] = 1;
        results[1] = 1;
        for (int i = 2; i <= n; i++) {
            results[i] = results[i - 1] + results[i - 2];
        }

        return results[n];
    }
}
