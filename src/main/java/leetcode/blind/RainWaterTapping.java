package leetcode.blind;

public class RainWaterTapping {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 0, 1, 3, 2};
        System.out.println(getAmountOfRainWaterTapped(arr));
    }

    public static int getAmountOfRainWaterTapped(int[] array) {
        int sumRainWaterTapped = 0;
        int length = array.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int currentLeftMax = Integer.MIN_VALUE;
        int currentRightMax = Integer.MIN_VALUE;

        for (int leftCounter = 0; leftCounter < length; leftCounter++) {
            currentLeftMax = Math.max(currentLeftMax, array[leftCounter]);
            left[leftCounter] = currentLeftMax;

            int rightCounter = length - 1 - leftCounter;
            currentRightMax = Math.max(currentRightMax, array[rightCounter]);
            right[rightCounter] = currentRightMax;
        }
        for (int i = 0; i < length; i++) {
            sumRainWaterTapped += Math.min(left[i], right[i]) - array[i];
        }
        return sumRainWaterTapped;
    }
}
