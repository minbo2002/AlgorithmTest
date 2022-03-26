package flab.week2;

/*
카데인 알고리즘 문제   https://sustainable-dev.tistory.com/23

Given an integer array nums, find the contiguous subarray (containing at least one number)
which has the largest sum and return its sum.
A subarray is a contiguous part of an array.

ex1)
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

ex2)
Input: nums = [1]
Output: 1

ex3)
Input: nums = [5,4,-1,7,8]
Output: 23

Constraints)
1 <= nums.length <= 105
-104 <= nums[i] <= 104

 */

// 카데인 알고리즘 문제   https://sustainable-dev.tistory.com/23
public class MaximumSubarray_53 {

    class Solution {

        public int maxSubArray(int[] nums) {   //  [-2, 1, -3, 4, -1, 2, 1, -5, 4]

            int localMax = nums[0];  // -2
            int globalMax = nums[0]; // -2

            for(int i=1; i<nums.length; i++) {  // nums.length=9

                localMax = Math.max(nums[i], localMax + nums[i]);
                // i=1일때  .max( 1, (-2)+1 ) -> localMax = 1
                // i=2일때  .max( -3, 1+(-3) ) -> localMax = -2
                // i=3일때  .max( 4, (-2)+4 ) -> localMax = 4
                // i=4일때  .max( (-1), 4+(-1) ) -> localMax = 3
                // i=5일때  .max( 2, 3+2 ) -> localMax = 5
                // i=6일때  .max( 1, 5+1 ) -> localMax = 6
                // i=7일때  .max( (-5), 6+(-5) ) -> localMax = 1
                // i=8일때  .max( 4, 1+4 ) -> localMax = 5

                if(localMax > globalMax) {
                    globalMax = localMax;
                }
            }

            return globalMax;
        }
    }
}
