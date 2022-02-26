package stringAlgorithm;

/* 7. 회문 문자열
 *
 *  앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
 *  문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 *  단 회문을 검사할 때 대소문자를 구분하지 않습니다.
 *
 *  입력 : 첫 줄에 길이 100을 넘지않는 공백이 없는 문자열이 주어집니다.
 *
 *  출력 : 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
 *
 * */

import java.util.Scanner;

public class PalindromeString_7 {

// 짝수 문자열의 경우 (문자열 길이)/2 를 한다음, 예를들어 문자열 길이가 4이면 4/2 = 2이므로 index 0,3과 1,2를 비교
//                                                                                  (0,1,2,3)

// 홀수 문자열의 경우 (문자열 길이)/2 를 한다음, 예를들어 문자열 길이가 5이면 5/2 = 2이므로 index 0,5와 1,4를 비교
//                                                                       index 3은 문자1개니까 비교 안해도됨
//                                                                      (0,1,2,3,4,5)
    public String solution(String str) {

        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();   // 문자열 str을 역전시키고
        if(str.equalsIgnoreCase(tmp))  answer="YES";    // 원래 문자열과 역전 문자열을 비교
        return answer;                                  // .toString() : 객체가 가지고있는 값을 문자열로 return
    }


    public String solution2(String str) {

        String answer = "YES";
        str=str.toUpperCase();  // .toUpperCase() : 전부 대문자가 됨  (이 문제는 대소문자 구분안하니까 전부 대문자로 바꿔버림)
        int len = str.length();

        for(int i=0; i<len/2; i++) {
            if(str.charAt(i) != str.charAt(len-i-1))  return "NO";
        // .charAt(index번호) : String 문자열중에서 한글자만 char형 문자로 변환
        //  예를들어 str="gooG"; --> index(0,1,2,3) 에서 i=0이면 len=4이므로 len-i-1=3 즉  index 0번째 g와 index 3번째 G를 비교
        }
        return answer;
    }

    public static void main(String[] args) {

        PalindromeString_7 ps = new PalindromeString_7();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(ps.solution(str));
    }
}
