package baekjoon.graph;

import java.util.*;

public class _1707_이분그래프 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<Integer>[] links = new List[V + 1];
            for (int j = 1; j <= V; j++) {
                links[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                links[from].add(to);
                links[to].add(from);
            }

            if (bfs(links, V)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean bfs(List<Integer>[] links, int V) {
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0) {
                q.add(i);
                visited[i] = 1;
            }

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int j = 0; j < links[now].size(); j++) {
                    int next = links[now].get(j);
                    if (visited[next] == 0) {
                        q.add(next);
                    }

                    if (visited[next] == visited[now]) {
                        return false;
                    }

                    if (visited[now] == 1) {
                        visited[next] = 2;
                    } else {
                        visited[next] = 1;
                    }
                }
            }
        }

        return true;
    }
}
