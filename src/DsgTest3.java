import java.util.*;

public class DsgTest3 {

    //  뒤집는 소수

    private boolean isPrime(int res) {
        // 소수 판별
        if(res == 1) return false;
        else {
            for (int i = 2; i < res / 2; i++) {
                if(res%i == 0) return false;
            }
        }
        return true;
    }

    private List<Integer> solution(int n, int[] arr) {
        // map + 최대값 + count

        List<Integer> answer = new ArrayList<>();

        // .NumberFormatException
//        for (int i = 0; i < n; i++) {
//            StringBuilder sb = new StringBuilder(arr[i]).reverse();
//            answer = Integer.parseInt(sb.toString());
//        }
        for (int i = 0; i < n; i++) {
            int res=0;
            int tmp = arr[i];

            while (tmp > 0) {
                int t = tmp%10;
                tmp = tmp / 10;
                res = res*10 + t;
            }
            if(isPrime(res)) answer.add(res);
        }

        return answer;
    }



    public static void main(String[] args) {

        DsgTest3 T = new DsgTest3();

        Scanner sc = new Scanner(System.in);

//        String str = sc.next();

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, arr));
    }



}
