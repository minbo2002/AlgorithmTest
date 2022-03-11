package arrayAlgorithm;

/* 10. 봉우리

* 지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
  각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다.
  봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
  격자의 가장자리는 0으로 초기화 되었다고 가정한다.
  만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.
*
*
* 입력 : 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
        두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
        실제 네모칸 볼때 가장자리 0은 없다고 본다.
        ex) 5

            0 0 0 0 0 0 0
            0 5 3 7 2 3 0
            0 3 7 1 6 1 0
            0 7 2 5 3 4 0
            0 4 3 6 4 1 0
            0 8 7 3 5 2 0
            0 0 0 0 0 0 0
    ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
      index   0 1 2 3 4

* 출력 : 봉우리의 개수를 출력하세요.
        ex) 10

                   k=  0  1  2  3
   방향배열 int[] dx = {-1, 0, 1, 0}
   방향배열 int[] dy = { 0, 1, 0,-1}

   행좌표 nx = i + dx[k]  /  열좌표 ny = j + dy[k]

   예를들어 i=1, j=2 이라면 1행2열의 값은 1이고
   arr[i][j] = arr[1][2] = 1 기준으로 12시,3시,6시,9시 방향의 값 arr[nx][ny] 과 비교해서 봉우리인지 확인

   k가 0~3까지 돌때
   12시방향 k=0이면 -> 행좌표 nx=1+dx[0] = 1-1 = 0  | 열좌표 ny=2+dy[0] = 2+0 = 2  -> arr[nx][ny] = arr[0][2]
    3시방향 k=1이면 -> 행좌표 nx=1+dx[1] = 1+0 = 1  | 열좌표 ny=2+dy[1] = 2+1 = 3  -> arr[nx][ny] = arr[1][3]
    6시방향 k=2이면 -> 행좌표 nx=1+dx[2] = 1+1 = 2  | 열좌표 ny=2+dy[2] = 2+0 = 2  -> arr[nx][ny] = arr[2][2]
    9시방향 k=3이면 -> 행좌표 nx=1+dx[3] = 1+0 = 1  | 열좌표 ny=2+dy[3] = 2-1 = 1  -> arr[nx][ny] = arr[1][1]

*  */

import java.util.Scanner;

public class Peaks_10 {

    int[] dx = {-1, 0, 1, 0};  // 방향배열
    int[] dy = {0, 1, 0, -1};  // 방향배열

    public int solution(int n, int[][] arr) {

        int answer = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {    // i, j가 결정되면 12시 3시 6시 9시 방향의 값을보고 봉우리인지 확인

                boolean flag = true;    // 봉우리인지 판별 (초기값 true)

                for(int k=0; k<4; k++) {

                    int nx = i + dx[k];  // nx는 행 좌표
                    int ny = j + dy[k];  // ny는 열 좌표

                    // index out of range 에러를 피하기 위해 nx>=0 && nx<n && ny>=0 && ny<n 조건 추가
                    if( nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny] >= arr[i][j] ) {
                        flag = false;       //  arr[nx][ny] 는 12시, 3시, 6시, 9시 방향을 의미
                        break;
                    }
                }

                if(flag) answer++;  // flag가 true라면 카운트1
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        Peaks_10 p = new Peaks_10();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print(p.solution(n, arr));
    }
}
