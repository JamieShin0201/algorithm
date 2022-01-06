package array;

import java.util.Arrays;

public class FindPivotIndex {

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = Arrays.stream(nums).sum();

        int pastPivot = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            rightSum -= num;
            leftSum += pastPivot;
            if (leftSum == rightSum) {
                return i;
            }

            pastPivot = num;
        }

        return -1;
    }
}
