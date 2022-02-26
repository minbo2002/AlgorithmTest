package stringAlgorithm;

/* 10. 가장 짧은 문자거리
 *
 *  한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 *  입력 : 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어진다.
 *        문자열의 길이는 100을 넘지 않는다.
 *        ex) teachermode e
 *
 *  출력 : 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 *        ex) 1 0 1 2 1 0 1 2 2 1 0
 * */

//  1) 각 문자의 왼쪽에 있는 문자t 와 떨어진 최소거리 구함
//  2) 각 문자의 오른쪽에 있는 문자t 와 떨어진 최소거리 구함. 이때 1) 과정에서 구한 거리와 비교에서 작은걸 선택

import java.util.Scanner;

public class ShortestCharacterDistance_10 {

    public int[] solution(String str, char c) {

        int[] answer = new int[str.length()];   // 문자열의 길이 .length()를 구하고 배열의 크기 결정.

        // 순서 1) 각 문자의 왼쪽에 있는 문자t 와 떨어진 최소거리 구함
        int p = 1000;  // 문자c와 떨어진 거리 p -->  처음시작할때 왼쪽이나 오른쪽에 문자가 없으면 무한대길이여서 대충 큰값을 지정해줌
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i)==c) {    //  비교문자 c와 해당 index의 문자가 같다면
                p = 0;
                answer[i] = p;   //  거리p를 0으로 바꾸고 해당 index에 넣어준다.
            }else {
                p++;
                answer[i] = p;   // 비교문자 c와 해당 index의 문자가 같지 않으면 거리를 1증가시켜서 해당 index에 넣는다.
            }
        }   // teachermode e
            // 1001 0123012340 (각 문자의 왼쪽문자 c비교)

        // 순서 2) 각 문자의 오른쪽에 있는 문자t 와 떨어진 최소거리 구함. 이때 1) 과정에서 구한 거리와 비교에서 작은걸 선택
        p=1000;
        for(int i=str.length()-1; i>=0; i--) {  // 제일 오른쪽 index부터 시작해서 index 0까지
            if(str.charAt(i)==c) {    //  비교문자 c와 해당 index의 문자가 같다면
                p = 0;  //  거리p를 0으로 바꾼다 순서1)에 의해서 이미 해당 idnex에는 0값이 있음.
            }else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }   // teachermode e
            // 1001 0123012340 (각 문자의 왼쪽문자 c비교)
            //     10121012210 (각 문자의 오른쪽문자 c비교)

        return answer;
    }

    public static void main(String[] args) {

        ShortestCharacterDistance_10 scd = new ShortestCharacterDistance_10();
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); //  .next() : 문자열에서 공백전까지 입력받아 String 타입으로 return
        char c = sc.next().charAt(0);   // .charAt(index번호) : String 문자열중에서 한글자만 char형 문자로 변환

        for(int x : scd.solution(str, c)) {
            System.out.print(x + " ");
        }

    }
}
