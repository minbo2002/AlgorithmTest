package stringAlgorithm;

/* 4. 단어 뒤집기
 *
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
 *
 * 입력 : 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
 *        두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다
 *
 * 출력 : N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
 *
 * */

import java.util.ArrayList;
import java.util.Scanner;

public class WordFlip_4 {

    public ArrayList<String> solution(int n, String[] str) {

        ArrayList<String> answer = new ArrayList<>();

        /*for(String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();   // StringBuilder() : 문자열을 다루는 클래스
                                                                      //                  (객체를 1개만 만들기 때문에 String에 비해 메모리 낭비가 적다.)
            answer.add(tmp);                                          // .reverse() : 역전 메서드
        }*/

        for(String x : str) {
            char[] s = x.toCharArray();  // toCharArray()  :   문자열을 한글자씩 쪼개서 char형 배열로 변경
                                         //                    (String은 변경못하지만 char형 배열은 가능)
            int lt=0, rt=x.length()-1; // lt : int값 0으로 초기화 (index 0번째, rt : 문자열길이-1 즉 맨끝 index번째
            while (lt<rt) {
                char tmp = s[lt];  // index lt번째의 char형 배열을 문자 tmp로 선언
                s[lt] = s[rt];  // index lt번째 char형 배열에다가 rt번째 char형 배열 넣어줌
                s[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(s); //  .valueOf() : s라는 char형 배열을 문자열로 변경
            answer.add(tmp);
        }

        return answer;
    }

    public static void main(String[] args) {
        WordFlip_4 wf = new WordFlip_4();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //  .nextInt()  :  정수를 입력받고 엔터처리는 하지않는다.
        String[] str = new String[n];  // String 배열을 n개 만듬

        for(int i=0; i<n; i++) {
            str[i] = sc.next();     // n개의 단어를 str 배열에 넣는다
        }
        for(String x : wf.solution(n, str)) {   //
            System.out.println(x);
        }
    }
}
