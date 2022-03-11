package arrayAlgorithm;

/* 9. 격자판 최대합

* 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
  N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.


* 입력 : 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
        두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
        ex) 5
            10 13 10 12 15
            12 39 30 23 11
            11 25 50 53 15
            19 27 29 37 27
            19 13 30 13 19

* 출력 : 최대합을 출력합니다.
        ex) 155

*/

import java.util.Scanner;

public class GridMaxSum_9 {

    public int solution(int n, int[][] arr) {

        int answer = Integer.MIN_VALUE; // 처음에 가장 작은 정수로 초기화
        int sum1, sum2; // sum1은 행의 합, sum2는 열의 합

        // 1) 행, 열의 합
        for(int i=0; i<n; i++) {  // i는 행,  j는 열

            sum1=sum2=0;  // i행의 합, j열의 합 0으로 초기화

            for(int j=0; j<n; j++) {
                sum1+=arr[i][j];   // i행은 고정되고 j열만 0~n까지 (행의 합)
                sum2+=arr[j][i];   // i행은 고정되고 j열만 0~n까지 (열의 합)
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);  // sum1 행의 합과 sum2 열의 합중 큰값이 answer에 들어감
        }

        // 2) 대각선의 합
        sum1=sum2=0;  // i행의 합, j열의 합 0으로 초기화

        for(int i=0; i<n; i++) {
            sum1+=arr[i][i];     // 왼쪽위에서 오른쪽아래로 향하는 대각선 합
            sum2+=arr[i][n-i-1]; // 오른쪽위에서 왼쪽아래로 향하는 대각선 합
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);  // sum1 행의 합과 sum2 열의 합중 큰값이 answer에 들어감

        return answer;
    }

    public static void main(String[] args) {

        GridMaxSum_9 gm = new GridMaxSum_9();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(gm.solution(n, arr));
    }
}
