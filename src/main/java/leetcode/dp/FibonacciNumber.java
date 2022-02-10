package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumber {

    private static List<Integer> numbers;

    static {
        numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(1);
    }

    public static void main(String[] args) {
        System.out.println(fibDp(4));
//        System.out.println(fibRecursiveDp(4));
    }

    // Top-down
    public static int fibRecursiveDp(int n) {
        if (n < numbers.size()) {
            return numbers.get(n);
        }

        int nextNumber = fibRecursiveDp(n - 1) + fibRecursiveDp(n - 2);
        numbers.add(nextNumber);
        return nextNumber;
    }

    // Bottom-up
    // 여러 케이스에서는 리스트 초기화 필요
    public static int fibDp(int n) {
        if (n < numbers.size()) {
            return numbers.get(n);
        }

        for (int i = 2; i <= n; i++) {
            int nextNumber = numbers.get(i - 1) + numbers.get(i - 2);
            numbers.add(nextNumber);
        }

        return numbers.get(n);
    }
}
