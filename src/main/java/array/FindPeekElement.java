package array;

public class FindPeekElement {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 4, 5, 6, 7, 8};
        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] < nums[pivot + 1]) {
                left = pivot + 1;
            } else {
                right = pivot;
            }
        }

        return left;
    }
}
