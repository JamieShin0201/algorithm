package graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {

    public static void main(String[] args) {
        List<List<Integer>> rooms = List.of(List.of(1), List.of(2), List.of(3), List.of());
        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, 0, visited);
        return visited.size() == rooms.size();
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
