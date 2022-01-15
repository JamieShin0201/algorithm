package graph;

import java.util.*;

public class KeysAndRooms {

    public static void main(String[] args) {
        List<List<Integer>> rooms = List.of(List.of(1), List.of(2), List.of(3), List.of());
        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        // dfs(rooms, 0, visited);
        // bfs(rooms, 0, visited);
        iterateDfs(rooms, 0, visited);
        return visited.size() == rooms.size();
    }

    private static void iterateDfs(List<List<Integer>> rooms, int index, Set<Integer> visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(index);

        while (!stack.isEmpty()) {
            int nowIndex = stack.pop();
            visited.add(index);

            for (int nextIndex : rooms.get(nowIndex)) {
                if (visited.contains(nextIndex)) {
                    continue;
                }

                visited.add(nextIndex);
                stack.push(nextIndex);
            }
        }
    }

    private static void bfs(List<List<Integer>> rooms, int index, Set<Integer> visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(index);
        while (!queue.isEmpty()) {
            int nowIndex = queue.poll();
            visited.add(nowIndex);
            for (int nextIndex : rooms.get(nowIndex)) {
                if (visited.contains(nextIndex)) {
                    continue;
                }

                queue.offer(nextIndex);
            }
        }
    }

    private static void dfs(List<List<Integer>> rooms, int index, Set<Integer> visited) {
        if (visited.contains(index)) {
            return;
        }

        visited.add(index);
        for (int nextIndex : rooms.get(index)) {
            dfs(rooms, nextIndex, visited);
        }
    }
}
