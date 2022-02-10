package baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class _9093_단어뒤집기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String line = sc.nextLine() + "\n";
            for (char c : line.toCharArray()) {
                if (c == ' ' || c == '\n') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                } else {
                    stack.push(c);
                }
            }
        }
        System.out.println(sb);
    }
}
