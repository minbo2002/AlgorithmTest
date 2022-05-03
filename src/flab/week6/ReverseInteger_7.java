package flab.week6;

import java.util.Scanner;

public class ReverseInteger_7 {  // Interger Reverse

    class Solution {
        public int reverse(int x) {

            // 반환타입 int로하면 input으로 1534236469 들어가면 output 1056389759 나와서 에러남
            long result = 0L;

            while(x != 0) {

                int target = x;

                target = x % 10;  // 나머지
                x = x / 10;  // 몫
                result = (result * 10) + target;
            }

            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }

            return (int) result;
        }
    }
}
