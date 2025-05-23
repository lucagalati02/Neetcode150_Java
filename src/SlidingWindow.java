public class SlidingWindow {
    public int maxProfit(int[] prices) {
        //https://neetcode.io/problems/buy-and-sell-crypto
        //14:56
        int left = 0;            // potential buy day
        int maxProfit = 0;

        // try selling on every later day
        for (int right = 1; right < prices.length; right++) {
            int profit = prices[right] - prices[left];
            maxProfit = Math.max(profit, maxProfit);
            // if today’s price is lower than your current buy, reset buy here
            if (prices[right] < prices[left]) {
                left = right;
            }
        }

        return maxProfit;
    }
}
