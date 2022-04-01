package twoPointer_slidingWindow;

/* 5. 연속된 자연수 합 (수학 방식)

*  N 입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로
  정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
  만약 N=15이면

 첫번째 방법) 7+8=15
 두번째 방법) 4+5+6=15
 세번째 방법) 1+2+3+4+5=15

 와 같이 총 3가지의 경우가 존재한다.


* 입력 : 첫 번째 줄에 양의 정수 N(7<=N<1000)이 주어집니다.
        ex) 15


* 출력 : 첫 줄에 총 경우수를 출력합니다.
        ex) 3


*/

import java.util.Scanner;

public class SumConsecutiveNumbers_5_2 {

    public int solution(int n) {

        // 연속된 자연수 개수만큼 1부터 순차적으로 증가시키고 합한것을 n에서 뺀다음 나머지를 n으로 나눠서 고르게 분배
        // ex) n=15, 2개의 연속된 자연수 --> 1, 2  // 3개의 연속된 자연수 1, 2, 3  //  5개의 연속된 자연수 1,2,3,4,5
        //     1+2=3  --> 15-3=12  --> 12/2개 = 6  --> 6씩 고르게 분배 --> 1+6, 2+6  -->  7,8
        //     1+2+3=6  -->  15-6=9  --> 9/3개 = 3  --> 3씩 고르게 분배  -->  1+3, 2+3, 3+3  --> 4,5,6
        //     1+2+3+4+5=15

        int answer=0, cnt=1;   // 만약 n=15라면
        n--;    // n=14
        while (n>0) {
            cnt++;        // cnt=2(연속된 자연수개수)  -->  cnt=3     -->  cnt=4    -->  cnt=5
            n = n - cnt;  //  n=14-2=12             -->  n=12-3=9  -->  n=9-4=5  -->  n=5-5=0

            if(n%cnt==0)  answer++;
            // 12%2==0  answer=1  -->  9%3==0  answer=2  -->   5%4!==0  -->  0%5=0  answer=3

            // 남은 n을 cnt로 나눌때 나머지가 0이면 연속된 자연수가 가능함
        }


        return answer;
    }

    public static void main(String[] args) {

        SumConsecutiveNumbers_5_2 scn_2 = new SumConsecutiveNumbers_5_2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(scn_2.solution(n));
    }
}
