package twoPointer_slidingWindow;

/* 5. 연속된 자연수 합 (two pointers algorithm)

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

public class SumConsecutiveNumbers_5 {

    public int solution(int n) {

        int answer=0, sum=0, lt=0;
        int m = (n/2)+1; // 입력한 양의정수 n을 /2하고 +1한 숫자가 있어야 최소한 연속된 2개 이상의 숫자가 나올수 있다.
        int [] arr = new int[m];  // n=15라면 m=8  index 0 1 2 3 4 5 6 7

        for(int i=0; i<m; i++)  arr[i] = i+1; // i번째 index에 i+1양의정수 들어감

        for(int rt=0; rt<m; rt++) {
            sum += arr[rt];

            if(sum==n)  answer++;

            while (sum>=n) {
                sum -= arr[lt++];
                if(sum==n)  answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        SumConsecutiveNumbers_5 scn = new SumConsecutiveNumbers_5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(scn.solution(n));
    }
}
