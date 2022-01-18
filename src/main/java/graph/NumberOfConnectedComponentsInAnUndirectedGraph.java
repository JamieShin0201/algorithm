package graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

    private static List<Integer>[] links;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(countComponents(n, edges));
    }

    public static int countComponents(int n, int[][] edges) {
        links = new List[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            links[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            links[edge[0]].add(edge[1]);
            links[edge[1]].add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            } else {
                count++;
                dfs(i);
            }
        }

        return count;
    }

    private static void dfs(int v) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;
        for (int nextV : links[v]) {
            dfs(nextV);
        }
    }
}
