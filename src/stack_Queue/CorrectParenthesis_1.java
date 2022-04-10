package stack_Queue;
/*

1. 올바른 괄호(Stack)

설명 : 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.
      (())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.


입력 : 첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.
      ex)  (()(()))(()

출력 : 첫 번째 줄에 YES, NO를 출력한다.
      ex)  NO


Stack : 나중에 들어간게 먼저 나오는 LIFO 구조이다. 들어가고 나가는곳이 한곳이다.
        pop()  : Stack에서 자료를 꺼내고 없앰.
        push() : Stack에 자료를 넣는것.
        isEmpty() : Stack이 비어있으면 true / 비어있지않으면 false


Queue : 먼저 들어간게 먼저나오는 FIFO 구조이다.

*/

import java.util.Scanner;
import java.util.Stack;

public class CorrectParenthesis_1 {

    public String solution(String str) {
        String answer = "YES";

        Stack<Character> stack = new Stack<>();

        for(char x : str.toCharArray()) {

            // x가 여는괄호일때
            if(x=='(')  stack.push(x);  // x가 여는괄호면 stack에 넣는다.

                // x가 닫는괄호일때
            else {
                // 1) 닫는 괄호가 많은상황
                if(stack.isEmpty())  return "NO";  // stack이 비어있으면 (즉, 여는괄호가 없어서 stack이 비어있으므로 닫는 괄호를 처리할 수 없는 상황)
                stack.pop();  // stack에 있는 자료 꺼내고 없앰.
            }
        }

        // 2) 여는 괄호가 많은상황
        if(!stack.isEmpty())  return "NO";  // stack이 비어있지않을때 true

        // 3) 닫는 괄호, 여는괄호가 같은 상황
        return answer;
    }

    public static void main(String[] args) {

        CorrectParenthesis_1 cp = new CorrectParenthesis_1();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.printf(cp.solution(str));

    }
}
