package arrayAlgorithm;

/* 8. 등수 구하기

* N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
  같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
  즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
*
*
* 입력 : 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
        ex) 5
            87 89 92 100 76

* 출력 : 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
        ex) 4 3 2 1 5

      i=0 일때 87
      j 87 89 92 100 76

*  */

import java.util.ArrayList;
import java.util.Scanner;

public class GetRank_8 {

    public int[] solution(int n, int [] arr) {

        int [] answer = new int[n];

        for(int i=0; i<n; i++) {
            int cnt = 1;  // i번 학생의 등수는 처음 1등으로 초기화

            for(int j=0; j<n; j++) {
                if(arr[j]>arr[i]) cnt++;
            }
            answer[i] = cnt;
        }

        return answer;
    }

    public static void main(String[] args) {

        GetRank_8 gr = new GetRank_8();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int x : gr.solution(n, arr))
            System.out.print(x + " ");
    }
}
