package stringAlgorithm;

/* 6. 중복 문자 제거
 *
 *  소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
 *  중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
 *
 *  입력 : 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
 *
 *  출력 : 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
 *
 * */

import java.util.Scanner;

public class RemoveDuplicateCharacters_6 {

    public String solution(String str) {

        String answer = "";
        for(int i=0; i<str.length(); i++) {
            //  .charAt(index번호)  :  String 문자열중에서 한글자만 char형 문자로 변환
            //  .indexOf()  :  문자열에서 특정 문자열을 찾고, 찾은 문자열중 '첫번째'로 나타나는 위치의 index를 return (찾는 문자열이 없으면 -1 return.  대소문자를 구분함.)
            //  .indexOf(String str, int fromIndex)  :  .indexOf(찾을문자열, 기본값0이고 index 시작위치)

            if(str.indexOf(str.charAt(i)) == i)  answer+=str.charAt(i);
            // 실제 index i번째 문자와 .indexOf() 메서드에 의해서 '첫번째'로 나타난 index 번호가 같다면 --> answer에 문자 누적
        }

        return answer;
    }

    public static void main(String[] args) {

        RemoveDuplicateCharacters_6 rdc = new RemoveDuplicateCharacters_6();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();  // .next() : 문자 or 문자열에서 공백전까지 입력받아 String 타입으로 return
        System.out.println(rdc.solution(str));
    }
}
