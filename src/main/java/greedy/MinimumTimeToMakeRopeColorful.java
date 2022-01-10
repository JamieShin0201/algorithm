package greedy;

public class MinimumTimeToMakeRopeColorful {

    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = {1, 2, 3, 4, 5};
        System.out.println(minCost(colors, neededTime));
    }

    public static int minCost(String colors, int[] neededTime) {
        char[] chars = colors.toCharArray();
        int length = chars.length;
        if (length <= 1) {
            return 0;
        }

        char lastChar = ' ';
        int maxCost = 0;
        int totalCost = 0;
        for (int i = 0; i < length; i++) {
            if (lastChar != chars[i]) {
                lastChar = chars[i];
                maxCost = neededTime[i];
            } else {
                if (neededTime[i] <= maxCost) {
                    totalCost += neededTime[i];
                } else {
                    totalCost += maxCost;
                    maxCost = neededTime[i];
                }
            }
        }

        return totalCost;
    }
}
