package baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class _13913_숨바꼭질4 {

    private static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] distance = new int[MAX];
        int[] before = new int[MAX];
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == K) {
                break;
            }

            int next1 = now - 1;
            if (next1 >= 0 && distance[next1] == 0) {
                q.add(next1);
                before[next1] = now;
                distance[next1] = distance[now] + 1;
            }

            int next2 = now + 1;
            if (next2 < MAX && distance[next2] == 0) {
                q.add(next2);
                before[next2] = now;
                distance[next2] = distance[now] + 1;
            }

            int next3 = now * 2;
            if (next3 < MAX && distance[next3] == 0) {
                q.add(next3);
                before[next3] = now;
                distance[next3] = distance[now] + 1;
            }
        }

        System.out.println(distance[K]);
        Stack<Integer> stack = new Stack<>();
        stack.push(K);
        int index = K;

        while (index != N) {
            stack.push(before[index]);
            index = before[index];
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
