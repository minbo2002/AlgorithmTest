package twoPointer_slidingWindow;

/* 2. 공통원소 구하기 (two pointers algorithm) (교집합)

* A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.
*
*
* 입력 : 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
        두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
        세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
        네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
        각 집합의 원소는 1,000,000,000이하의 자연수입니다.
        ex) 5
            1 3 9 5 2
            5
            3 2 5 7 8


* 출력 : 두 집합의 공통원소를 오름차순 정렬하여 출력합니다.
        ex) 2 3 5

       <Pointer1 변수>                                <Pointer1 변수>
        index 0  1  2  3  4                          index 0  1  2  3  4
        ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ                       ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
      a |     1  3  9  5  2     --> .sort(a) -->   a |     1  2  3  5  9

        <Pointer2 변수>                               <Pointer2 변수>
        index 0  1  2  3  4                          index 0  1  2  3  4
        ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ                         ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
      b |     3  2  5  7  8     --> .sort(b) -->    b |     2  3  5  7  8

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FindingCommonElements_2 {   // a[p1] < b[p2] 에서 a[p1] 값이 작으면 a[p1++]로 이동.  같으면 a[p1++] b[p2++] 동시에 증가

    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b) {

        ArrayList<Integer> answer = new ArrayList<>();

        Arrays.sort(a);
        Arrays.sort(b);

        int p1=0, p2=0;

        while (p1<n && p2<m) {       // p1이 n까지 가거나 p2가 m까지 가면 false이므로 while문 벗어남

            if(a[p1] == b[p2]) {       // a[p1]과 b[p2]값이 같으면 동시에 a[p1++] b[p2++]
                answer.add(a[p1++]); // a[p1]의 값을 add하고 p1++
                p2++;

            } else if(a[p1] < b[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        FindingCommonElements_2 fe = new FindingCommonElements_2();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i=0; i<m; i++) {
            b[i] = sc.nextInt();
        }

        for(int x : fe.solution(n, m, a, b))
            System.out.print(x + " ");
    }
}
