package stringAlgorithm;

/* 2. 대소문자 변환

 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여
 * 출력하는 프로그램을 작성하세요.
 *
 * 입력 : 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
 *          ( 문자열은 영어 알파벳으로만 구성되어 있습니다. )
          ex) StuDY

 * 출력 : 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
          ex) sTUdy

 *   */

import java.util.Scanner;

public class CaseConversion_2 {

    public String solution(String str) {
        String answer = "";
        for(char x : str.toCharArray()) {   // .toCharArray() : 문자열을 한글자씩 쪼개서 char형 배열로 변경
            if(Character.isLowerCase(x)) answer+=Character.toUpperCase(x);
            //  .isLowerCase() : 소문자인지 판별 (맞으면 true 틀리면 false)
            //  .toUpperCase() : 대문자인지 판별 (맞으면 true 틀리면 false)
            else answer+=Character.toLowerCase(x);
        }
        return answer;

        // 아스키숫자 -->  대문자 65~90  소문자 97~122
    }

    public static void main(String[] args) {
        CaseConversion_2 cc = new CaseConversion_2();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();     //  .next()  :  문자 or 문자열에서 공백전까지 입력받아 String 타입으로 return

        System.out.println(cc.solution(str));
    }
}
