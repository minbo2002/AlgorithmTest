package arrayAlgorithm;

/* 6. 뒤집은 소수

* N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
  예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
  첫 자리부터의 연속된 0은 무시한다.
*
*
* 입력 : 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
        ex) 9
            32 55 62 20 250 370 200 30 100

* 출력 : 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
        ex) 23 2 73 2 3

*  */

/*  tmp = 1230 으로 가정 (tmp>0 이어야하고 뒤집으면 321나와야함)
    res = 0 초기화

    t = tmp  % 10     res = res * 10 + t     tmp = tmp  / 10
    0 = 1230 % 10      0  =  0  * 10 + 0     123 = 1230 / 10
    3 = 123  % 10      3  =  0  * 10 + 3     12  = 123  / 10
    2 = 12   % 10     32  =  3  * 10 + 2     1   = 12   / 10
    1   1    % 10    321  = 32  * 10 + 1     0   =  1   / 10

    --> tmp = 1230 일때 결과값 res = 321
*/

import java.util.ArrayList;
import java.util.Scanner;

public class InvertedPrime_6 {

    public boolean inPrime(int res) {
        if(res==1) return false;

        for(int i=2; i<res; i++) {
            if(res%i==0) return false;  // 약수가 존재한다면
        }

        return true;
    }

    public ArrayList<Integer> solution(int n, int [] arr) {

        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0; i<n; i++) {
            int tmp = arr[i];

            int res = 0;        // 뒤집힌숫자 res를 처음에 0으로 초기화함.
            while (tmp>0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }

            if(inPrime(res))  answer.add(res);
        }
        return answer;
    }


    public static void main(String[] args) {

        InvertedPrime_6 ip = new InvertedPrime_6();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int x : ip.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
