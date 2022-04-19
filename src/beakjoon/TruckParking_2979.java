package beakjoon;

import java.util.Scanner;

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
