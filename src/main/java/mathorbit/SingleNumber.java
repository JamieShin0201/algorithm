package mathorbit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumberUsingXOR(nums));
    }

    public static int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        return set.stream()
                .findFirst()
                .get();
    }

    public static int singleNumberUsingXOR(int[] nums) {
        return Arrays.stream(nums).reduce(0, (x, y) -> x ^= y);
    }
}
