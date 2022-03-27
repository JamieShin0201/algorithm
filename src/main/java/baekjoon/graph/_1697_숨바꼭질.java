package baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1697_숨바꼭질 {
    private static final int MAX = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] distance = new int[MAX];
        boolean[] visited = new boolean[MAX];

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = true;
        distance[N] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();

            int next1 = now - 1;
            if (next1 >= 0) {
                if (!visited[next1]) {
                    q.add(next1);
                    visited[next1] = true;
                    distance[next1] = distance[now] + 1;
                }
            }

            int next2 = now + 1;
            if (next2 < MAX) {
                if (!visited[next2]) {
                    q.add(next2);
                    visited[next2] = true;
                    distance[next2] = distance[now] + 1;
                }
            }

            int next3 = now * 2;
            if (next3 < MAX) {
                if (!visited[next3]) {
                    q.add(next3);
                    visited[next3] = true;
                    distance[next3] = distance[now] + 1;
                }
            }
        }
        System.out.println(distance[K]);
    }
}
