package leetcode.blind;

public class StocksBuyAndSell {

   public int maxProfit(int[] array) {
        int maxProfit = Integer.MIN_VALUE;
        int minPriceSoFar = Integer.MAX_VALUE;
        for (int i : array) {
            minPriceSoFar = Math.min(minPriceSoFar, i);
            maxProfit = Math.max(maxProfit, i - minPriceSoFar);
        }
        return maxProfit;
    }
}
