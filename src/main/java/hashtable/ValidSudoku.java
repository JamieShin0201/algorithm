package hashtable;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        Map<Character, Integer> map = new HashMap<>();
        for (char[] chars : board) {
            for (char ch : chars) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getKey() != '.' && entry.getValue() > 1) {
                    return false;
                }
            }
            map.clear();
        }

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                map.put(board[j][i], map.getOrDefault(board[j][i], 0) + 1);
            }

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getKey() != '.' && entry.getValue() > 1) {
                    return false;
                }
            }
            map.clear();
        }

        for (int i = 0; i < board.length; i = i + 3) {
            for (int j = 0; j < 3; j++) {
                map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
                map.put(board[i + 1][j], map.getOrDefault(board[i + 1][j], 0) + 1);
                map.put(board[i + 2][j], map.getOrDefault(board[i + 2][j], 0) + 1);
            }

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getKey() != '.' && entry.getValue() > 1) {
                    return false;
                }
            }
            map.clear();

            for (int j = 3; j < 6; j++) {
                map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
                map.put(board[i + 1][j], map.getOrDefault(board[i + 1][j], 0) + 1);
                map.put(board[i + 2][j], map.getOrDefault(board[i + 2][j], 0) + 1);
            }

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getKey() != '.' && entry.getValue() > 1) {
                    return false;
                }
            }
            map.clear();

            for (int j = 6; j < 9; j++) {
                map.put(board[i][j], map.getOrDefault(board[i][j], 0) + 1);
                map.put(board[i + 1][j], map.getOrDefault(board[i + 1][j], 0) + 1);
                map.put(board[i + 2][j], map.getOrDefault(board[i + 2][j], 0) + 1);
            }

            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getKey() != '.' && entry.getValue() > 1) {
                    return false;
                }
            }
            map.clear();
        }

        return true;
    }
}
