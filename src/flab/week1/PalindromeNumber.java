package flab.week1;

/*

Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward.
For example, 121 is a palindrome while 123 is not.

ex1)
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

ex2)
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

ex3)
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

제약)
-231 <= x <= 231 - 1

*/

import java.util.Scanner;

public class PalindromeNumber {

    static class Solution {
        public boolean isPalindrome(int x) {

            if(x<0) {
                return false;
            }
            else {
                int tmp = x;
                int res = 0;

                while(tmp>0) {
                    int t = tmp%10;
                    res = res * 10 + t;
                    tmp = tmp / 10;
                }

                return res == x;
            }
        }
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(sol.isPalindrome(x));
    }
}
