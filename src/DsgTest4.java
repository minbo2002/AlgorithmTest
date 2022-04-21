public class DsgTest4 {

    static int[] fibo;

    public int DFS(int n) {
        // 종료 조건

        if(fibo[n] > 0) return fibo[n];     // 메모제이션 key : 이코드 없고 있고의 성능차이가 확실함! 왼쪽 트리 값을 미리 기록해서 return
        if(n == 1) return fibo[n]=1;
        else if(n == 2) return fibo[n]=2;
        else {
            return fibo[n] = DFS(n-1)+DFS(n-2);
        }
    }

    public static void main(String[] args) {
        DsgTest4 T = new DsgTest4();
        int n = 50;
        fibo = new int[n + 1];   // 1부터 시작
        T.DFS(n);               // 미리 계산해
        for(int i=1; i<=n; i++){    // 1부터 시작
            System.out.print(fibo[i]+" ");
        }
    }
}