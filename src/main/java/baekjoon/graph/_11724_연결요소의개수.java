package baekjoon.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _11724_연결요소의개수 {

    private static List<Integer>[] links;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        visited = new boolean[N + 1];
        links = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            links[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            links[from].add(to);
            links[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                continue;
            }
            count++;
            dfs(i);
        }

        System.out.println(count);
    }

    private static void dfs(int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        for (int next : links[node]) {
            dfs(next);
        }
    }
}
