package stringAlgorithm;

/* 9. 숫자만 추출
 *
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
 * 만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.
 * 추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.
 *
 *  입력 : 첫 줄에 숫자가 썩인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
 *         ex) g0en2T0s8eSoft
 *
 *  출력 : 첫 줄에 자연수를 출력합니다.
 *
 * */

//  AscII 코드 -->  문자형숫자 '0' (48) ~ 문자형숫자 '9' (57)
//  answer=0  answer = answer * 10 + (x-48)
//              0    =   0    * 10 + (48-48)
//              1    =   0    * 10 + (49-48)
//              12   =   1    * 10 + (50-48)
//              120  =   12   * 10 + (48-48)
//              1205 =   120  * 10 + (53-48)

import java.util.Scanner;

public class ExtractOnlyNumbers_9 {

    public int solution(String str) {

        int answer = 0;
        for(char x : str.toCharArray()) {  // toCharArray() : 문자열을 한글자씩 쪼개서 char형 배열로 변경
            if (x>=48 && x<=57)  answer = answer * 10 + (x - 48);
            // 문자형숫자'0' : AscII 코드 48  ,  문자형숫자'9' : AscII 코드 57
        }
        return answer;
    }


    public int solution2(String str) {

        String answer = "";
        for(char x : str.toCharArray()) {
            if(Character.isDigit(x)) answer+=x;  // .isDigit() : char문자형 값의 숫자여부를 판단하여 true 혹은 false를 return
        }
        return Integer.parseInt(answer);    //  .parseInt() : 문자열을 정수로 바꾼다
    }


    public static void main(String[] args) {

        ExtractOnlyNumbers_9 eon = new ExtractOnlyNumbers_9();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(eon.solution2(str));
    }
}
