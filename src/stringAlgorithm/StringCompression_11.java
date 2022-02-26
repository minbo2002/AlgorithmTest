package stringAlgorithm;

/* 11. 문자열 압축
 *
 *  알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우
 *  반복되는 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
 *  단 반복횟수가 1인 경우 생략합니다.
 *
 *  입력 : 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *        ex) KKHSSSSSSSE
 *
 *  출력 : 첫 줄에 압축된 문자열을 출력한다.
 *        ex) K2HS7E
 * */

import java.util.Scanner;

public class StringCompression_11 {

    public String solution(String str) {

        String answer = "";
        str = str + " "; // index 지점과 그 다음 index 지점을 비교할때 마지막 index 뒤에는 빈문자를 두고 비교
        int cnt = 1;  // 일단 index 0에 문자가 무조건 1개있으니까

        for(int i=0; i<str.length()-1; i++) {   // .length()-1  빈문자는 길이에 포함되면 안되므로
            
            if(str.charAt(i) == str.charAt(i+1))  // 해당 index 문자와 그 다음 index의 문자가 같다면
                cnt++;
            else {
                answer += str.charAt(i);  // 해당 index 문자를 넣어주고
                if(cnt>1) answer += String.valueOf(cnt);  // .valueOf() : char형 배열을 문자열로 변경
                                                          // 단 cnt가 1보다 클때
                cnt=1;  // cnt는 1로 초기화
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        StringCompression_11 scom = new StringCompression_11();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(scom.solution(str));
    }
}
