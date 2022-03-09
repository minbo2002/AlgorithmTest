package arrayAlgorithm;

/* 1. 큰 수 출력하기

* N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
* (첫 번째 수는 무조건 출력한다)
*
* 입력 : 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
        ex) 6
            7 3 9 5 6 12

* 출력 : 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
        ex) 7 9 6 12

*  */

import java.util.ArrayList;
import java.util.Scanner;

public class PrintLargeNumbers_1 {

    public ArrayList<Integer> solution (int n, int[] arr) {

        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i=1; i<n; i++) {
            if(arr[i]>arr[i-1]) answer.add(arr[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        PrintLargeNumbers_1 pl = new PrintLargeNumbers_1();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for(int x : pl.solution(n, arr))
            System.out.print(x + " ");

    }
}
