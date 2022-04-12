package flab.week4;

public class LongestPalindromicSubstring_5 {

    class Solution {

        public String longestPalindrome(String s) {  // simple 알고리즘 방법

            if (s.isEmpty()) {
                return null;
            }

            if (s.length() == 1) {
                return s;
            }

            String longest = s.substring(0, 1);
            // .substring(indexStart, indexEnd) : 시작index에서 종료index까지 문자열의 부분문자열을 반환.
            // 단 indexEnd는 포함하지않음. ex) String str = 'apple' str.substring(1,3) --> "pp"

            for (int i = 0; i < s.length(); i++) {

                // get longest palindrome with center of i
                String tmp = longSubstring(s, i, i);
                if (tmp.length() > longest.length()) {
                    longest = tmp;
                }

                // get longest palindrome with center of i, i+1
                tmp = longSubstring(s, i, i + 1);
                if (tmp.length() > longest.length()) {
                    longest = tmp;
                }
            }

            return longest;
        }


        public String longSubstring(String s, int start, int end) {
            while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;

            }
            return s.substring(start + 1, end);
            // .substring(indexStart, indexEnd) : 시작index에서 종료index까지 문자열의 부분문자열을 반환.
            // 단 indexEnd는 포함하지않음. ex) String str = 'apple' str.substring(1,3) --> "pp"
        }
    }
}


/*

    class Solution {

        public String longestPalindrome(String s) {

            if (s == null || s.length() < 1) return "";  // 문자열이 null 이거나 길이가 1보다 작으면 ""

            int start = 0, end = 0;

            for (int i = 0; i < s.length(); i++) {

                int len1 = expandAroundCenter(s, i, i);  // 길이가 홀수라고 가정
                int len2 = expandAroundCenter(s, i, i + 1);  // 길이가 짝수라고 가정
                int len = Math.max(len1, len2);

                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
            // .substring(indexStart, indexEnd) : 시작index에서 종료index까지 문자열의 부분문자열을 반환.
            // 단 indexEnd는 포함하지않음. ex) String str = 'apple' str.substring(1,3) --> "pp"
        }

        private int expandAroundCenter(String s, int left, int right) {

            int L = left, R = right;

            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }

            return R - L - 1;
        }
    }

 */
