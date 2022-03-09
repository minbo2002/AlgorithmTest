package arrayAlgorithm;

/* 3. 가위바위보

* A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다.
  비길 경우에는 D를 출력합니다.
  가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
  두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
*
* 입력 : 첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
        두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
        세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
        ex) 5
            2 3 3 1 3
            1 1 2 2 3


* 출력 : 각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
*       ex) A
            B
            A
            B
            D
*/

import java.util.ArrayList;
import java.util.Scanner;

public class RockPaperScissors_3 {

    // A랑 B랑 비교해서 A가 1. 비기는경우 2. 가위로 이기는경우 3. 바위로 이기는경우 4. 보로 이기는 경우 5. 나머지는 지는
    public String solution(int n, int[] a, int[] b) {

        String answer = "";
        for(int i=0; i<n; i++) {
            if(a[i]==b[i])  answer+="D";  // 비기는경우
            else if(a[i]==1 && b[i]==3) answer+="A"; // A가 가위로 이기는경우
            else if(a[i]==2 && b[i]==1) answer+="A"; // A가 바위로 이기는경우
            else if(a[i]==3 && b[i]==2) answer+="A"; // A가 바위로 이기는경우
            else answer+="B";  // 나머지는 B가 이기는경우
        }

        return answer;

    }

    public static void main(String[] args) {

        RockPaperScissors_3 rps = new RockPaperScissors_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] a = new int[n];
        int [] b = new int[n];

        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++) {
            b[i] = sc.nextInt();
        }

        for(char x : rps.solution(n, a, b).toCharArray())
            System.out.println(x);
    }
}
