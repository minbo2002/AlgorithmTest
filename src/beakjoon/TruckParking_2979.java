package beakjoon;

import java.util.Scanner;

/*
상근이는 트럭을 총 세 대 가지고 있다. 오늘은 트럭을 주차하는데 비용이 얼마나 필요한지 알아보려고 한다.
상근이가 이용하는 주차장은 주차하는 트럭의 수에 따라서 주차 요금을 할인해 준다.
트럭을 한 대 주차할 때는 1분에 한 대당 A원을 내야 한다.
두 대를 주차할 때는 1분에 한 대당 B원,
세 대를 주차할 때는 1분에 한 대당 C원을 내야 한다.
A, B, C가 주어지고, 상근이의 트럭이 주차장에 주차된 시간이 주어졌을 때,
주차 요금으로 얼마를 내야 하는지 구하는 프로그램을 작성하시오.

첫째 줄에 문제에서 설명한 주차 요금 A, B, C가 주어진다. (1 ≤ C ≤ B ≤ A ≤ 100)
다음 세 개 줄에는 두 정수가 주어진다.
이 정수는 상근이가 가지고 있는 트럭이 주차장에 도착한 시간과 주차장에서 떠난 시간이다.
도착한 시간은 항상 떠난 시간보다 앞선다. 입력으로 주어지는 시간은 1과 100사이 이다.
 */

public class TruckParking_2979 {

    public static void main(String[] args) {

        /*
        5 3 1
        1 6
        3 5
        2 8
        */

        // index  0 1 2 3 4 5 6 7 8
        //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
        // arr[j]   1 1 1 1 1          (start=1 end=6)
        // arr[j]       1 1            (start=3 end=5)
        // arr[j]     1 1 1 1 1 1      (start=2 end=8)
        // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

        Scanner sc = new Scanner(System.in);

        int price1 = sc.nextInt(); // 1대일때 1대당 주차가격
        int price2 = sc.nextInt(); // 2대일때 1대당 주차가격
        int price3 = sc.nextInt(); // 3대일때 1대당 주차가격

        int[] arr = new int[101];  // 입력 시간 1과 100사이
        int start = 0;
        int end = 0;
        int maxTime=0, result=0;

        for(int i=0; i<3; i++) {   // i=0 start<j<end
            start = sc.nextInt();
            end = sc.nextInt();

            for(int j=start; j<end; j++) {
                arr[j]++;
                maxTime = Math.max(maxTime, end);
            }
        }

        for(int i=1; i<maxTime; i++) {
            if(arr[i]==1) result+=price1;
            if(arr[i]==2) result+=price2 * 2;
            if(arr[i]==3) result+=price3 * 3;
        }

        System.out.println(result);
    }
}
