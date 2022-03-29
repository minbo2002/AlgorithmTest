package flab.week2;

import flab.week1.PalindromeNumber;

import java.util.Scanner;

public class ValidPalindrome_125 {

    static class Solution {

        public boolean isPalindrome(String s) {

            boolean answer = false;

            s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
            //  s="A man, a plan, a canal: Panama"  --> s="a man a plan a canal panama"
            System.out.println(s);

            String rev = new StringBuilder(s).reverse().toString();

            if(s.equals(rev)) answer = true;

            return answer;

        }
    }

    public static void main(String[] args) {

        ValidPalindrome_125.Solution sol = new ValidPalindrome_125.Solution();
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        System.out.println(sol.isPalindrome(x));
    }
}
