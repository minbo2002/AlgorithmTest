package twoPointer_slidingWindow;

/* 4. 연속 부분수열 (two pointer)

* N개의 수로 이루어진 수열이 주어집니다.
  이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하는 프로그램을 작성하세요.
  만약 개수 N=8, 특정숫자 합 M=6이고 수열이 다음과 같다면
  1 2 1 3 1 1 1 2
  합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지입니다.

*
* 입력 : 첫째 줄에 N(1≤N≤100,000), M(1≤M≤100,000,000)이 주어진다.
        수열의 원소값은 1,000을 넘지 않는 자연수이다.
        ex) 8 6
            1 2 1 3 1 1 1 2

* 출력 : 첫째 줄에 경우의 수를 출력한다.
        ex) 3


           rt
           lt
    index  0 1 2 3 4 5 6 7
    ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
     arr   1 2 1 3 1 1 1 2

*/

import java.util.Scanner;

public class ContinuousSubsequence_4 {

    public int solution(int n, int m, int[] arr) {

        int answer=0, sum=0, lt=0;

        for(int rt=0; rt<n; rt++) {

            sum += arr[rt];   // sum = lt부터 rt까지의 합

            if(sum==m) answer++;  // index의 값을 다 더한게 k값과 같다면 answer 경우의수 1증가

            while(sum>=m) {  // lt값 1번 빼고도 합이 6이 넘는 경우도 있으므로 while문 사용
                sum -= arr[lt++];  // 기존 lt값 뺀다음에 lt증가
                if(sum==m) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        ContinuousSubsequence_4 cs = new ContinuousSubsequence_4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(cs.solution(n, m, arr));
    }
}
