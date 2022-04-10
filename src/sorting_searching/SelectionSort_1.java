package sorting_searching;
/*

1. 선택정렬(Sorting)

설명 : N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
      정렬하는 방법은 선택정렬입니다.


입력 : 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
      두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다.
      각 자연수는 정수형 범위 안에 있습니다.
      ex)  6
          13 5 11 7 23 15


출력 : 오름차순으로 정렬된 수열을 출력합니다.
      ex)  5 7 11 13 15 23


선택정렬은 선형탐색을 이용해서 배열에서 가장 작은 숫자를 찾고,
배열의 가장 왼쪽에 있는 숫자와 위치를 바꾼다. 이 과정을 계속 반복함.
2중 for문이므로 시간복잡도 O(n^2)

      i  j--------->
index 0  1 2  3 4  5
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
arr  13 5 11 7 23 15

*/


import java.util.Scanner;

public class SelectionSort_1 {

    public int[] solution(int n, int [] arr) {

        for(int i=0; i<n; i++) {  // 마지막 자료인 n까지 갈 필요가 없음

            int index=i;

            for(int j=i+1; j<n; j++) {
                if(arr[j] < arr[index])  index = j;  // 가장 작은값이 있는 index번호로 교체
            }

            int tmp = arr[i];
            arr[i] = arr[index];
            arr[index] = tmp;
        }

        return arr;
    }

    public static void main(String[] args) {

        SelectionSort_1 ss = new SelectionSort_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int x : ss.solution(n, arr)) System.out.print(x + " ");
    }
}
