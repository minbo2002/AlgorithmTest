package flab.week4;

public class ClimbingStairs_70 {

    class Solution {
        public int climbStairs(int n) {  // 재귀, DP 방법으로 풀어야함 (피보나치 수열 풀이와 같음)

            int[] dp = new int [n+1];  // ex) n=4일때  index 0 1 2 3 4

            if(n < 3) {
                return n;
            }

            dp[1] = 1;
            dp[2] = 2;

            for(int i=3; i<dp.length; i++) {   // ex) dp[3]=3 , dp[4]=5
                dp[i] = dp[i-1] + dp[i-2];
                // i번째 계단을 오르는 경우의 수는
                // --> i-1 번째 계단에서 1계단 오르는 경우의수 + n-2번째 계단에서 2계단 오르는 경우의 수
            }

            return dp[n];  // ex) dp[4] = 5
        }
    }
}
