package baekjoon.graph;

import java.util.*;

public class _1260_DFS와BFS {

    private static List<Integer>[] g;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        visited = new boolean[N + 1];
        g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            g[from].add(to);
            g[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(g[i]);
        }

        dfs(V);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(V);
    }

    private static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        visited[start] = true;
        stack.push(start);
        System.out.print(start + " ");

        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (int i = 0; i < g[node].size(); i++) {
                int next = g[node].get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    System.out.print(next + " ");
                    stack.push(node);
                    stack.push(next);
                    break;
                }
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int node = q.remove();
            System.out.print(node + " ");

            for (int next : g[node]) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                q.add(next);
            }
        }
    }
}
