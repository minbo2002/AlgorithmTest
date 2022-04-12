package flab.week4;

public class BestTimeToBuyAndSellStock_121 {

    class Solution {

        public int maxProfit(int[] prices) {

            int minPrice = Integer.MAX_VALUE;
            int maxProfit = 0;

            for (int p : prices) {  //  ex)  [7,1,5,3,6,4]
                minPrice = Math.min(minPrice, p);  // 배열중에서 가장 최소금액을 찾고
                maxProfit = Math.max(maxProfit, p - minPrice);  //  p - minPrice 이득이 최대인곳을 찾는다
            }

            return maxProfit;
        }
    }
}

// index0일때(1일차) minprice : 7   maxProfit : 0
// index1일때(2일차) minprice : 1   maxProfit : 0
// index1일때(3일차) minprice : 1   maxProfit : 4
// index1일때(4일차) minprice : 1   maxProfit : 4
// index1일때(5일차) minprice : 1   maxProfit : 5
// index1일때(6일차) minprice : 1   maxProfit : 5
