package hashtable;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    private static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s) {
        String[] elements = s.split("");
        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            int value = map.get(elements[i]);
            if (i == elements.length - 1) {
                sum += value;
                break;
            }

            int nextValue = map.get(elements[i + 1]);
            if (value < nextValue) {
                sum -= value;
            } else {
                sum += value;
            }
        }

        return sum;
    }
}
