package stringAlgorithm;
import java.util.Scanner;

/* 1. 문자찾기

* 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에
* 몇 개 존재하는지 알아내는 프로그램을 작성하세요. (대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.)
*
* 입력 : 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다. (문자열은 영어 알파벳으로만 구성되어 있습니다.)
        ex) Computercooler
            c

* 출력 : 첫 줄에 해당 문자의 개수를 출력한다
        ex) 2

*  */

public class FindLetters_1 {

    public int solution(String str, char c) {
        int answer = 0;
        str = str.toUpperCase();    // .toUpperCase() : 전부 대문자가 됨
        c = Character.toUpperCase(c);   // 문자c를 .toUpperCase(c) 사용해서 대문자로 변경

        for (char x : str.toCharArray()) {     // .toCharArray()  :  문자열을 한글자씩 쪼개서 char형 배열로 변경
            if(x==c) answer++;
        }

        return answer;
    }

    public int solution2(String str, char c) {
        int answer = 0;
        str = str.toUpperCase();    // .toUpperCase() : 전부 대문자가 됨
        c = Character.toUpperCase(c);   // 문자c를 .toUpperCase(c) 사용해서 대문자로 변경

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)==c) answer++;  //  .charAt(index번호) : String 문자열중에서 한글자만 char형 문자로 변환
        }

        return answer;
    }

    public static void main(String[] args) {
        FindLetters_1 fl = new FindLetters_1();

        Scanner sc = new Scanner(System.in);
        String str = sc.next(); //  .next() : 문자 or 문자열에서 공백전까지 입력받아 String 타입으로 return
        char c = sc.next().charAt(0);    //  .next().charAt(0) : 문자열에서 문자1개만 index 0번째 접근

        System.out.println(fl.solution(str, c));
    }
}
