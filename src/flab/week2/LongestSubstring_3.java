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

public class LongestSubstring_3 {

    class Solution {
        public int lengthOfLongestSubstring(String s) {

            // 한 글자씩만 나와야한다. ex) abca 는 a 가 두번나오므로 안된다.
            int maxLength = 0;
            int i=0, j=0;
            int length = s.length();

            HashSet<Character> stringSet = new HashSet<>();
            // HashSet은 객체를 저장하기전에 먼저 객체의 hashCode() 메소드 호출해서 해시코드 얻어낸다음
            // 저장되어있는 객체들의 해시코드와 비교하고 같은 해시코드가 있으면 equals() 메소드로 두 객체 비교해서
            // true가 나오면 동일한 객체로 판단하고 중복저장 하지않는다.

            // 문자열을 HashSet으로 저장하면 같은 문자열의 경우 동일 객체로 간주해서 중복저장 하지않는다.
            // 이유 : String 클래스의 경우 hashCode()와 equals() 메소드를 재정의해서 같은 문자열의 경우
            //       hasgCode() 메소드의 return 값을 같게하고, equals() 메소드의 return 값을 true로 나오게함.

            while (j < length) {  // length : 입력한 문자열 길이 6

                if(i > j) break;

                if (!stringSet.contains(s.charAt(j))){  // p w w k e w
                    // .charAt() : index가 문자열 길이보다 크면 빈 문자열 " " 리턴
                    // .contains() : 특정 문자가 있으면 true, 없으면 false

                    stringSet.add(s.charAt(j++));
                    // j=0이므로 .add() 메서드에 의해 stringSet에 p를 저장한다음  j는 0 -> 1로 증가

                    maxLength = Math.max(maxLength, j - i);  // .max(0, 1-0) -> 1이므로 maxLength=1

                    continue;
                }

                stringSet.remove(s.charAt(i++));
                // j=2 일경우  stringSet="pw"에서  i=0이므로
                // .remove() 메서드에 의해 stringSet에 "p"제거하고 true리턴하고  i는 0 -> 1로 증가

            }

            return maxLength;
        }
    }
}
