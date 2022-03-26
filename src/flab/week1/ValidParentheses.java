package flab.week1;

/*

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

ex1)
Input: s = "()"
Output: true

ex2)
Input: s = "()[]{}"
Output: true

ex3)
Input: s = "(]"
Output: false

제약)
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.

*/

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    class Solution {
        public boolean isValid(String s) {

            Map <Character, Character> map = Map.of( ')', '(', '}', '{', ']', '[' );
            // Map.of()  :  2개이상의 (k,v) 쌍을 호출하면 ImmutableCollections 안에있는 MapN<K,V> 객체를 만든다.
            Stack <Character> stack = new Stack<>();

            for (Character c : s.toCharArray()) {

                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    //  stack 자료구조는 마지막에 추가된 데이터가 가장 먼저 나오는 LIFO 동작
                    //  stack 자료구조에서 데이터가 push되고 .pop() 메서드를 통해 마지막에 들어간 데이터를 추출하고 stack 에서 제거
                    return false;
                }
            }

            return stack.isEmpty();  // .isEmpty()  :  문자열의 길이가 0이면 true를 리턴
        }
    }
}
