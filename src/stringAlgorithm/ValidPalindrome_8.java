package stringAlgorithm;

/* 8. 유효한 팰린드롬
 *
 *  앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
 *  문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
 *  단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
 *  알파벳 이외의 문자들의 무시합니다.
 *
 *  입력 : 첫 줄에 길이 100을 넘지않는 공백이 없는 문자열이 주어집니다.
 *        ex) found7, time: study; Yduts; emit, 7Dnuof
 *
 *  출력 : 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
 *        ex) YES
 * */

import java.util.Scanner;

public class ValidPalindrome_8 {

    public String solution (String str) {

        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        System.out.println(str);
        // .toUpperCase() : 전부 대문자가 됨     .toLowerCase() : 전부 소문자가 됨
        // .replaceAll("[^A-Z]", "")  :  .replaceAll(정규식 대문자 A~Z가 아니라면, 빈문자로 대체한다)
        String tmp = new StringBuilder(str).reverse().toString();   // .toString() : 객체가 가지고있는 값을 문자열로 return
        if(str.equals(tmp)) answer="YES";

        return answer;
    }

    public static void main(String[] args) {

        ValidPalindrome_8 vp = new ValidPalindrome_8();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();  //  .nextLine() : 문자 or 엔터치기 전까지 문자열 전체를 입력받아 String 타입으로 return
        System.out.println(vp.solution(str));
    }
}
