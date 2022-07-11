import leetcode.blind.StocksBuyAndSell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StocksBuyAndSellTest {

    StocksBuyAndSell stocksBuyAndSell = new StocksBuyAndSell();

    @Test
    public void testMaxProfit() {
        int[] arr = {3, 1, 4, 8, 7, 2, 5, 15, 0};
        assertEquals(0, stocksBuyAndSell.maxProfit(arr), 14);
    }
}
