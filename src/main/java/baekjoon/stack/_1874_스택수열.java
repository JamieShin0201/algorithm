package baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class _1874_스택수열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int value : values) {
            if (value > count) {
                while (value > count) {
                    stack.push(++count);
                    sb.append("+\n");
                }
            } else {
                if (stack.peek() != value) {
                    System.out.println("NO");
                    return;
                }
            }

            stack.pop();
            sb.append("-\n");
        }
        System.out.println(sb);
    }
}
