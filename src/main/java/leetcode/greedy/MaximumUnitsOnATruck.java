package leetcode.greedy;

import java.util.Arrays;

public class MaximumUnitsOnATruck {

    public static void main(String[] args) {
        int[][] boxTypes = {{1, 3}, {5, 5}, {2, 5}, {4, 2}, {4, 1}, {3, 1}, {2, 2}, {1, 3}, {2, 5}, {3, 2}};
        int truckSize = 35;
        System.out.println(maximumUnits(boxTypes, truckSize));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);

        int result = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            if (boxTypes[i][0] <= truckSize) {
                result += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                result += truckSize * boxTypes[i][1];
                truckSize = 0;
            }

            if (truckSize == 0) {
                break;
            }
        }
        return result;
    }
}
