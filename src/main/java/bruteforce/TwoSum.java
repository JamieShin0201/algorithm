package bruteforce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSumByHashMap(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSumByHashMap(new int[]{3, 2, 4}, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }

    public static int[] twoSumByHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int value = map.getOrDefault(target - nums[i], -1);
            if (value != -1) {
                answer[0] = i;
                answer[1] = value;
                break;
            }

            map.put(nums[i], i);
        }
        return answer;
    }
}
