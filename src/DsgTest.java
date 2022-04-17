import java.util.Scanner;

public class DsgTest {

    //  뒤집기

    private String solution(String str) {
        // Stringbuilder
        String answer = "";
//
//        StringBuilder sb = new StringBuilder(str).reverse();
//
//        answer = sb.toString();

        //
        char[] ch = str.toCharArray();
        char tmp = ' ';

        for (int i = 0; i < ch.length / 2; i++) {
            //swap
//            tmp = ch[i];
//            ch[i] = ch[ch.length - i - 1];
//            ch[ch.length - i - 1] = tmp;
            // 팰린드롬 판별법
            if(ch[i] == ch[ch.length - i - 1]){
                return "true";
            }
        }

        answer = String.valueOf(ch);

        return answer;
    }

    public static void main(String[] args) {

        DsgTest T = new DsgTest();

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }



}
