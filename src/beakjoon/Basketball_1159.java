package beakjoon;

import java.util.Scanner;

/*
농구 선수중에서 누가 선발인지 기억하기 쉽게 하기 위해 성의 첫 글자가 같은 선수 5명을 선발하려고 한다.
만약, 성의 첫 글자가 같은 선수가 5명보다 적다면, 내일 있을 친선 경기를 기권하려고 한다.
상근이는 내일 경기를 위해 뽑을 수 있는 성의 첫 글자를 모두 구해보려고 한다.

input : 첫째 줄에 선수의 수 N (1 ≤ N ≤ 150)이 주어진다. 다음 N개 줄에는 각 선수의 성이 주어진다.
        (성은 알파벳 소문자로만 이루어져 있고, 최대 30글자이다)

output : 상근이가 선수 다섯 명을 선발할 수 없는 경우에는 "PREDAJA" (따옴표 없이)를 출력한다.
         PREDAJA는 크로아티아어로 항복을 의미한다.
         선발할 수 있는 경우에는 가능한 성의 첫 글자를 사전순으로 공백없이 모두 출력한다.

ex) 6           -->     PREDAJA
    michael
    jordan
    lebron
    james
    kobe
    bryant
 */
public class Basketball_1159 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        char[] index = new char[num];
        int[] arr = new int[26];
        int result = 0;

        for(int i=0; i<index.length; i++) {  // 소문자 a 아스키코드 97
            String str = sc.next();
            index[i]=str.charAt(0);
            arr[index[i]-97]++;
        }
        for(int i=0; i<arr.length; i++) {
            if(arr[i]>=5) {
                System.out.print((char)(i+97));
                result++;
            }
        }
        if(result==0) {
            System.out.println("PREDAJA");
        }
    }
}
