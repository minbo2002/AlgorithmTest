package flab.week3;

/*
https://velog.io/@timevoyage/leetcode-76-Minimum-Window-Substring
참고

문자열 t가 문자열 s에 완전이 포함될때 가장 작은 부분문자열을 구해라

Input :  s = "ADOBECODEBANC", t = "ABC"

Output  :  "BANC"

 */

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {

    class Solution {
        public String minWindow(String s, String t) {

            if (s.length() == 0 || t.length() == 0) {
                return "";
            }

            Map<Character, Integer> dictT = new HashMap<Character, Integer>();

            for (int i = 0; i < t.length(); i++) {
                int count = dictT.getOrDefault(t.charAt(i), 0);
                dictT.put(t.charAt(i), count + 1);
            }

            int required = dictT.size();

            // Left and Right pointer
            int l = 0, r = 0;

            int formed = 0;

            // Dictionary which keeps a count of all the unique characters in the current window.
            Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();

            // ans list of the form (window length, left, right)
            int[] ans = {-1, 0, 0};

            while (r < s.length()) {
                // Add one character from the right to the window
                char c = s.charAt(r);
                int count = windowCounts.getOrDefault(c, 0);
                windowCounts.put(c, count + 1);

                // If the frequency of the current character added equals to the
                // desired count in t then increment the formed count by 1.
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                    formed++;
                }

                // Try and contract the window till the point where it ceases to be 'desirable'.
                while (l <= r && formed == required) {
                    c = s.charAt(l);
                    // Save the smallest window until now.
                    if (ans[0] == -1 || r - l + 1 < ans[0]) {
                        ans[0] = r - l + 1;
                        ans[1] = l;
                        ans[2] = r;
                    }

                    // The character at the position pointed by the
                    // `Left` pointer is no longer a part of the window.
                    windowCounts.put(c, windowCounts.get(c) - 1);
                    if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                        formed--;
                    }

                    // Move the left pointer ahead, this would help to look for a new window.
                    l++;
                }

                // Keep expanding the window once we are done contracting.
                r++;
            }

            return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
        }
    }
}
