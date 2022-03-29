package flab.week2;

/*
Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.
(같은 문자가 2번이상 나오면 안되고 연속된 substring만 카운트)

ex1)
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

ex2)
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

ex3)
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints)
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */


// .substring(indexStart, indexEnd) : 시작index에서 종료index까지 문자열의 부분문자열을 반환
//  단 indexEnd는 포함하지않음.  ex) String str = 'apple'  str.substring(0,3)  --> "app"

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring_3 {

        class Solution {
            public int lengthOfLongestSubstring(String s) {

                Set<Character> subString = new HashSet<Character>();
                // HashSet은 객체를 저장하기전에 먼저 객체의 hashCode() 메소드 호출해서 해시코드 얻어낸다음
                // 저장되어있는 객체들의 해시코드와 비교하고 같은 해시코드가 있으면 equals() 메소드로 두 객체 비교해서
                // true가 나오면 동일한 객체로 판단하고 중복저장 하지않는다.

                // 문자열을 HashSet으로 저장하면 같은 문자열의 경우 동일 객체로 간주해서 중복저장 하지않는다.
                // 이유 : String 클래스의 경우 hashCode()와 equals() 메소드를 재정의해서 같은 문자열의 경우
                //       hasgCode() 메소드의 return 값을 같게하고, equals() 메소드의 return 값을 true로 나오게함.
                int max=0;
                int i=0, j=0;

                while (j < s.length()) {

                    char c = s.charAt(j++);

                    if (subString.add(c)) {

                        if (max < j-i)  max = j-i;

                    } else {

                        while (!subString.add(c)) {

                            subString.remove(s.charAt(i++));
                        }
                    }
                }
                return max;
            }

        }

}
