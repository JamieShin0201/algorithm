package baekjoon.deque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class _10866_덱 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String[] inputs = br.readLine().split(" ");
            String command = inputs[0];


            switch (command) {
                case "push_front":
                    int frontValue = Integer.parseInt(inputs[1]);
                    deque.addFirst(frontValue);
                    break;
                case "push_back":
                    int backValue = Integer.parseInt(inputs[1]);
                    deque.addLast(backValue);
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(deque.removeFirst() + "\n");
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(deque.removeLast() + "\n");
                    break;
                case "size":
                    sb.append(deque.size() + "\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(deque.peekFirst() + "\n");
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    }
                    sb.append(deque.peekLast() + "\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.close();
    }
}
