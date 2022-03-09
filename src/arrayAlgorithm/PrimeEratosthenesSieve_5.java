package arrayAlgorithm;

/* 5. 소수(에라토스테네스 체)

* 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
  만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
*
*
* 입력 : 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
        ex) 20

* 출력 : 첫 줄에 소수의 개수를 출력합니다.
        ex) 8

*  */


// index 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 (배열길이 21)
//       | | | | | | | | | | |  |  |  |  |  |  |  |  |  |  |
//       0 0 0 0 0 0 0 0 0 0 0  0  0  0  0  0  0  0  0  0  0  (index 값)


// // 배열 초기값 --> int 0  /  char '0' /  String null  / boolean false /  double 0.0  /  커스텀클래스 null
import java.util.Scanner;

public class PrimeEratosthenesSieve_5 {

    public int solution (int n) {

        int answer = 0;
        int[] ch = new int[n+1];  // 배열길이[n+1]까지 해줘야 자연수n을 입력했을때 index n번까지 생성된다.

        for(int i=2; i<n; i++) {  // index 0,1은 소수 아니므로 index 2부터 for문 돌림
            if(ch[i]==0) {
                answer++;

                for(int j=i; j<=n; j=j+i)   // 처음에 i=2이므로 2의배수를 전부 체크(1)해서 제외
                    ch[j]=1;  // 배수들의 index값을 1로 해줘서 answer 카운팅 안되게 한다.
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        PrimeEratosthenesSieve_5 pes = new PrimeEratosthenesSieve_5();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(pes.solution(n));
    }
}
