package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _1406_에디터 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (char c : line.toCharArray()) {
            left.push(c);
        }
        int M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            String[] inputs = br.readLine().split(" ");
            String command = inputs[0];

            if (command.equals("L")) {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            } else if (command.equals("D")) {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            } else if (command.equals("B")) {
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else if (command.equals("P")) {
                left.push(inputs[1].charAt(0));
            }
        }

        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}
