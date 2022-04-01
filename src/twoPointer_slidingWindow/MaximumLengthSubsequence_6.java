package twoPointer_slidingWindow;

/* 6. 최대길이 연속 부분수열  (two pointers algorithm)

*  0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
  여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.

  만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
  1 1 0 0 1 1 0 1 1 0 1 1 0 1

  여러분이 만들 수 있는 1이 연속된 연속부분수열은

           |-----------------|
   1 1 0 0 | 1 1 1 1 1 1 1 1 |   이며 그 길이는 8입니다.
           |-----------------|


* 입력 : 첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
        두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.
        ex) 14 2
            1 1 0 0 1 1 0 1 1 0 1 1 0 1

* 출력 : 첫 줄에 최대 길이를 출력하세요.
        ex) 8


              rt
              lt
        index 0 1 2 3 4 5 6 7 8 9 10 11 12 13
        ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
              1 1 0 0 1 1 0 1 1 0 1  1  0  1


     // ex) n=14, k=2  -->  cnt는 3을 넘으면 안됨
     // rt=0일때 --> answer=1 , cnt=0    // rt=1일때 --> answer=2 , cnt=0
     // rt=2일때 --> answer=3 , cnt=1    // rt=3일때 --> answer=4 , cnt=2
     // rt=4일때 --> answer=5 , cnt=2    // rt=5일때 --> answer=6 , cnt=2
     // rt=6일때 --> cnt=3, lt=2 --> cnt=2 , lt=3 , answer=6
     // rt=7일때 --> answer=5
     // rt=8일때 --> answer=6
     // rt=9일때 --> answer=6, cnt=3, lt=3 --> cnt=2, lt=4, answer=6
     // rt=10일때 --> answer=7
     // rt=11일때 --> answer=8
     // rt=12일때 --> answer=8, cnt=3, lt=3  --> cnt=2, lt=6, answer=7
     // rt=13일때 --> answer=8
*/

import java.util.Scanner;

public class MaximumLengthSubsequence_6 {

    public int solution(int n, int k, int[] arr) {

        int answer=0 , cnt=0, lt=0;

        for(int rt=0; rt<n; rt++) {

            if(arr[rt]==0)  cnt++;  // cnt : 0을 1로 바꾼 횟수

            while (cnt > k) {   // k : 0을 1로 바꿀수있는 최대 횟수

                if(arr[lt]==0)
                cnt--;
                lt++;
            }

            answer = Math.max(answer, rt-lt+1);  // // rt-lt+1 : 1을 연속으로 갖는 수열의 길이
        }

        return answer;
    }


    public static void main(String[] args) {

        MaximumLengthSubsequence_6 mls = new MaximumLengthSubsequence_6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i]=sc.nextInt();
        }

        System.out.println(mls.solution(n, k, arr));

    }
}
