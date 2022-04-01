package twoPointer_slidingWindow;

/* 3. 최대 매출 (sliding window algorithm)

* 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.
  만약 N=10이고 K=3이면  10일동안의 매출기록중 연속된 3일동안의 최대매출은 아래와 같다.
  12 15 11 20 25 10 20 19 13 15
  연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.

*
*
* 입력 : 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
        두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
        ex) 10 3
            12 15 11 20 25 10 20 19 13 15

* 출력 : 첫 줄에 최대 매출액을 출력합니다.
        ex) 56


//  index 0  1  2  3  4  5  6  7  8  9
//        12 15 11 20 25 10 20 19 13 15

*/

import java.util.Scanner;

public class MaximumSales_3 {  // 시간복잡도 O(n)

    public int solution(int n, int k, int[] arr) {

        int answer=0, sum=0;

        for(int i=0; i<k; i++)
        sum += arr[i];  //
        answer = sum;

        for(int i=k; i<n; i++) {

            sum += (arr[i]-arr[i-k]);  // 앞에 index 1개씩 빼고 뒤에 index를 1개씩 더하는것과 같다.
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {

        MaximumSales_3 ms = new MaximumSales_3();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i]=sc.nextInt();
        }

        System.out.println(ms.solution(n, k, arr));

    }
}
