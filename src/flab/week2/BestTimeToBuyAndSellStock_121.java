package flab.week2;

public class BestTimeToBuyAndSellStock_121 {

    class Solution {

        public int maxProfit(int[] prices) {

            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;

            for (int p : prices) {
                minPrice = Math.min(minPrice, p);
                maxProfit = Math.max(maxProfit, p - minPrice);  //  p - minPrice 이득이 최대
            }

            return maxProfit;
        }
    }
}
