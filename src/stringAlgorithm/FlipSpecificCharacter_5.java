package stringAlgorithm;

/* 5. 특정 문자 뒤집기
 *
 *  영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
 *  특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
 *
 *  입력 : 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
 *
 *  출력 : 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
 *
 * */

import java.util.Scanner;

public class FlipSpecificCharacter_5 {

    public String solution(String str) {  // 여기서 str은 영어알파벳 + 특수문자로 구성된 문자열로 가정

        String answer;
        char[] s = str.toCharArray();   // toCharArray() : 문자열을 한글자씩 쪼개서 char형 배열로 변경
        int lt = 0, rt=str.length()-1;  // lt : int값 0으로 초기화 (index 0번째, rt : 문자열길이-1 즉 맨끝 index번째

        while (lt<rt) {
            if(!Character.isAlphabetic(s[lt])) lt++;       // .isAlphabetic() : 영문자 확인
            else if(!Character.isAlphabetic(s[rt])) rt--;  // 알파벳이 아닐때 참
            else {  // 알파벳이라면
                char tmp = s[lt];
                s[lt]=s[rt];
                s[rt]=tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(s);  //  .valueOf() : s라는 char형 배열을 문자열로 변경

        return answer;
    }

    public static void main(String[] args) {

        FlipSpecificCharacter_5 fsf = new FlipSpecificCharacter_5();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(fsf.solution(str));
    }
}
