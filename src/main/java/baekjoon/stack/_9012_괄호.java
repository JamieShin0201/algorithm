package baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class _9012_괄호 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String ps = sc.next();
            if (isValidPs(ps)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isValidPs(String ps) {
        Stack<Character> stack = new Stack<>();
        for (char c : ps.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            if (stack.peek() == ')') {
                return false;
            }

            stack.pop();
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
