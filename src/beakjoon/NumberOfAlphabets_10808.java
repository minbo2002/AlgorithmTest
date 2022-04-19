package beakjoon;

import java.util.Scanner;

public class NumberOfAlphabets_10808 {  // 아스키코드 소문자 a=97  ~  소문자 z=122

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int[] arr = new int[26];

        // char형 문자 + 문자 = 아스키코드 정수형으로 나옴
        // char형 문자 + 정수 = 문자를 아스키코드로 변환해서 정수형으로 나옴
        for(char x : str.toCharArray()) {
            arr[x-'a']++;
        }

        for(int i=0; i< arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
