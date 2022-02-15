package baekjoon.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _1158_요세푸스문제 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> q = IntStream.rangeClosed(1, N)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!q.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }

            if (q.size() == 1) {
                sb.append(q.poll());
            } else {
                sb.append(q.poll() + ", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
