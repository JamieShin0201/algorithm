package leetcode.dp;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost1 = {10, 15, 20};
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost1));
        System.out.println(minCostClimbingStairs(cost2));
    }

    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        for (int i = 2; i < length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[length - 1], cost[length - 2]);
    }
}
