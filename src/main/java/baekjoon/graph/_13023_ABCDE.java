package baekjoon.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _13023_ABCDE {

    private static boolean[] visited;
    private static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        g = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            g[from].add(to);
            g[to].add(from);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1);
        }

        System.out.println("0");
    }

    private static void dfs(int now, int count) {
        if (count == 5) {
            System.out.println("1");
            System.exit(0);
        }

        visited[now] = true;
        for (int i = 0; i < g[now].size(); i++) {
            int next = g[now].get(i);
            if (visited[next]) {
                continue;
            }

            dfs(next, count + 1);
        }
        visited[now] = false;
    }
}
