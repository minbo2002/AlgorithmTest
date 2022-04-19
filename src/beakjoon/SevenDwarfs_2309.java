package beakjoon;

import java.util.Arrays;
import java.util.Scanner;

public class SevenDwarfs_2309 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        int index1 = 0;
        int index2 = 0;

        for(int i=0; i<arr.length; i++) {  // 0 1 2 3 4 5 6 7
            arr[i]=sc.nextInt();  // 1 2 3 4 5 6 7 8
            sum+=arr[i];
        }

        Arrays.sort(arr);

        for(int i=0; i<arr.length-1; i++) {      // 전체 sum에서 특정 2명만 골라서 뺀다.
            for(int j=i+1; j<arr.length; j++) {
                if(sum-arr[i]-arr[j]==100) {
                    index1 = i;
                    index2 = j;
                    break;
                }
            }
        }

        for(int i=0; i<arr.length; i++) {
            if(i==index1 || i==index2) continue;
            System.out.println(arr[i]);
        }
    }
}
