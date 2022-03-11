package arrayAlgorithm;

/* 12. 멘토링

* 현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 위해 멘토링 시스템을 만들려고 합니다.
  멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.
  선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
  만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
  M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.


* 입력 : 첫 번째 줄에 반 학생 수 N(1<=N<=20)과 수학테스트 횟수 M(1<=L<=10)이 주어진다.
        두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다.
        학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.
        만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2로 입력되었다면
        3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.
        ex) 4 3  (4명학생 3번테스트)

           0등 1등 2등 3등
  0번테스트  3   4   1  2
  1번테스트  4   3   2  1
  2번테스트  3   1   4  2


* 출력 : 첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.
        (3, 1), (3, 2), (4, 2)와 같이 3가지 경우의 (멘토, 멘티) 짝을 만들 수 있다.
        ex) 3

 */

import java.util.Scanner;

public class Mentoring_12 {

    public int solution(int n, int m, int[][] arr) {

        int answer = 0;

        for(int i=1; i<=n; i++) {      // i는 학생번호, n은 학생수

            for(int j=1; j<=n; j++) {  // j는 학생번호, n은 학생수
                int cnt = 0;

                if(i!=j) {  // (i=j가 같은경우는 제외. 본인이 멘토, 멘티 둘다 될수는 없으니까)

                    for(int k=0; k<m; k++) {  // k,m은 테스트횟수
                        int pi=0, pj=0;

                        for(int s=0; s<n; s++) {    // s는 등수
                            if(arr[k][s]==i) pi=s;  // i번학생이 k번째테스트의 s등수와 값이 같으면 i번학생 등수pi은 s등수
                            if(arr[k][s]==j) pj=s;  // j번학생의 k번째테스트의 s등수와 값이 같으면 j번학생 등수pj는 s등수
                        }

                        if(pi<pj) cnt++;  // i번째 학생의등수가 j번째 학생의 등수보다 작으면 테스트 통과
                    }
                    if(cnt==m) {   // 처음에 입력한 m 테스트횟수와 cnt가 같아지면 (멘토가 되려면 m번의 테스트를 모두 통과해야하니까)
                        answer++;  // 경우의수 1증가
                    }
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Mentoring_12 mon = new Mentoring_12();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  // 학생수 n
        int m = sc.nextInt();  // 테스트횟수 m
        int [][] arr = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();  // 학생번호 입력
            }
        }

        System.out.println(mon.solution(n, m, arr));
    }
}
