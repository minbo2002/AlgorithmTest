package flab.week1;

/*

Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

ex1)
Input: strs = ["flower","flow","flight"]
Output: "fl"

ex2)
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

제약)
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lower-case English letters.

*/

public class LongestCommonPrefix {

    class Solution {
        public String longestCommonPrefix (String[] strs) {  // strs 배열의 첫번째 문자열을 기준으로 나머지 문자열들과 각 index 문자가 일치하는지 확인

            String str = "";
            boolean isDone = false;

            if (strs.length > 0) {

                for (int i=0; i<strs[0].length(); i++) {    // index 0번째 문자열

                    char c = strs[0].charAt(i);             // index 0번째 문자열의 문자를 각각 c에 담는다
                    str += String.valueOf(c);               // 문자들을 String으로 변환해서 str에 담는다.

                    for (int j=1; j<strs.length; j++) {     // index 1번째 문자열

                        if (!strs[j].startsWith(str)) {     //  string.startsWith(탐색할 문자열 대소문자 구분, index)
                                                            //  'abcde'.startsWith( 'a' )  -->  true 반환     /   'abcde'.startsWith( 'a', 1 )  --> bcde가 a로 시작하는지?  false 반환
                            isDone = true;
                            break;
                        }
                    }

                    if (isDone) {
                        str = str.substring(0, str.length() - 1);  // str.length() - 1 은 str의 마지막 index 의미함
                        // .substring(indexStart, indexEnd) : 시작index에서 종료index까지 문자열의 부분문자열을 반환
                        //  단 indexEnd는 포함하지않음.  ex) String str = 'apple'  str.substring(1,3)  --> "pp"
                        break;
                    }
                }
            }
            return str;
        }

    }

}
