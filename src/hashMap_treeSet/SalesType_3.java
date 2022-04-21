package hashMap_treeSet;

/* 3. 매출액의 종류(HashMap, Sliding Window)


* 현수의 아빠는 제과점을 운영합니다. 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를
  각 구간별로 구하라고 했습니다.
  만약 N=7이면 7일 간의 매출기록이 아래와 같고
  20 12 20 10 23 17 10
  이때 K=4 이면, 연속 4일간의 구간의 매출종류는

  첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
  두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
  세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
  네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.

  N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별
  매출액의 종류를 출력하는 프로그램을 작성하세요.


* 입력 : 첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
        두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
        ex) 7 4
            20 12 20 10 23 17 10


* 출력 : 첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.
        ex) 3 4 4 3


         lt       rt------->            n=7, k=4
  index  0  1  2  3  4  5  6            HashMap   Key   20  12  10  23  17
   arr   20 12 20 10 23 17 10                    Value  2   1   1
                                                 Value  1   1   1   1
                                                 Value  1       1   1   1
                                                 Value          2   1   1

   lt를 3일째까지 HashMap에 설정해놓고, rt를 4일째부터 돌도록 설정한다.

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SalesType_3 {

    public ArrayList<Integer> solution(int n, int k, int[] arr) {

        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> HM = new HashMap<>();

        for(int i=0; i<k-1; i++) {  // i는 연속구간길이 k-1 만큼 세팅해놓는다.
            HM.put(arr[i], HM.getOrDefault(arr[i],0) +1 );
            // .getOrDefault(key, defaultValue) : key에 있는 value값을 가져옴. key가 없으면 defaultValue 가져옴.
        }

        int lt=0;
        for(int rt=k-1; rt<n; rt++ ) {   // lt가 0번째 index부터 시작하므로 rt=k-1부터 시작
            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0) +1 );
            answer.add(HM.size());

            HM.put(arr[lt], HM.get(arr[lt]) -1 );
            // .get(key) : key에 있는 value값을 출력

            if(HM.get(arr[lt])==0)  HM.remove(arr[lt]);
            // arr[lt] 값이 0이면 해당 key를 체크하지않아야 하므로 key를 삭제
            // .remove(key) : 특정 key를 삭제
            lt++;
        }

        return answer;
    }


    public static void main(String[] args) {

        SalesType_3 st = new SalesType_3();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for(int x : st.solution(n, k, arr))  System.out.print(x + " ");
    }
}
