package stringAlgorithm;

/* 3. 문장 속 단어
 *
 * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
 *   (문장속의 각 단어는 공백으로 구분됩니다.)
 *
 * 입력 : 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
 *       ex) it is time to study
 *
 * 출력 : 첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
 *        단어를 답으로 합니다.
 *       ex) study
 * */

import java.util.Scanner;

public class WordInSentence_3 {

    public String resolution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;  // Integer.MIN_VALUE : 정수의 최소값
        System.out.println("m: "+m);
        String[] s = str.split(" ");    //  .split : 띄어쓰기 분리하고 String 배열에 저장
        for(String x : s) {
            int leng = x.length();  // 각 단어의 길이가 leng에 들어감
            if(leng>m) {  // 기존 단어길이 m보다 더 긴 단어길이 leng이 있다면
                m=leng;   // 기존 단어길이를 leng으로 바꿔준다.
                answer = x; // 단어를 교체
            }
        }
        return answer;
    }

    public String resolution2(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;  // Integer.MIN_VALUE : 정수의 최소값

        while ((pos=str.indexOf(' ')) != -1) {
            // .indexOf()  :  문자열에서 특정 문자열을 찾고, 찾은 문자열중 '첫번째'로 나타나는 위치의 index를 return (찾는 문자열이 없으면 -1 return.  대소문자를 구분함.)
            // .indexOf(' ')) != -1  : 띄어쓰기를 발견 못하면 -1을 반환하므로 while문 종료
            // ex) it is time to study 에서 띄어쓰기는 index값이 2,5,10,13일때이다

            String tmp = str.substring(0, pos);
            // .substring(indexStart, indexEnd) : 시작index에서 종료index까지 문자열의 부분문자열을 반환
            //  단 indexEnd는 포함하지않음.  ex) String str = 'apple'  str.substring(1,3)  --> "pp"
            //  it is time to study

            int leng = tmp.length();  // 각 단어의 길이가 leng에 들어감
            if(leng>m) {  // 기존 단어길이 m보다 더 긴 단어길이 leng이 있다면
                m=leng;   // 기존 단어길이를 leng으로 바꿔준다.
                answer = tmp; // 단어를 교체
            }
            str = str.substring(pos+1);  // pos는 빈칸을 의미하므로 다음 단어를 찾으려면 +1 해줘야함
                                         // .substring(indexStart) : indexStart 지점부터 문자열의 전체를 반환
        }

        if(str.length()>m) answer=str; // 마지막 단어의 크기가 m보다 크면 str로 바꾼다
        return answer;
    }

    public static void main(String[] args) {
        WordInSentence_3 ws = new WordInSentence_3();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();    //  .nextLine() : 문자 or 엔터치기 전까지 문자열 전체를 입력받아 String 타입으로 return
        System.out.println(ws.resolution(str));
    }
}
