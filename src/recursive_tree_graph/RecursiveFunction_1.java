package recursive_tree_graph;
/*

1. 재귀함수 (Stack Frame)

설명 : 자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지 출력하는 프로그램을 작성해라.

선택정렬
입력 : 첫번째 줄은 정수N (3<=N<=10)이 입력된다.
      ex)  3

출력 : 첫째 줄에 출력한다
      ex)  1 2 3


재귀함수는 자기자신의 함수를 호출하는것

    <Stack>                                    <Stack>

|  반환 주소값  |  solution(0) 호출          |  반환 주소값  |  solution(0) 종료
|  지역변수    |  line50 실행및 종료 pop      |  지역변수    |
|  매개변수    |                            |  매개변수    |
|  반환 주소값  |  solution(1) 호출          |  반환 주소값  |  solution(1) 종료
|  지역변수    |  line47 까지실행            |  지역변수    |  line47 복귀
|  매개변수    |                            |  매개변수    |
|  반환 주소값  |  solution(2) 호출          |  반환 주소값  |  solution(2) 종료
|  지역변수    |  line47 까지실행            |  지역변수    |  line47 복귀
|  매개변수    |                            |  매개변수    |
|  반환 주소값  |  solution(3) 호출    ---->  |  반환 주소값  |  solution(3) 종료
|  지역변수    |  line47 까지실행            |  지역변수    |  line47 복귀
|  매개변수    |                            |  매개변수    |
|  반환 주소값  |  main()                    |  반환 주소값  |  main() 종료
|  지역변수    |                            |  지역변수    |
|  매개변수    |                            |  매개변수    |

*/


public class RecursiveFunction_1 {

    public void solution(int n) {

        if(n==0) {
            return;  // void문에서 return; 은 함수의 종료를 뜻함

        }else {

            System.out.print(n + " ");  //  3 2 1
            solution(n-1);
            System.out.print(n + " ");  //  1 2 3 (pop)
        }
    }

    public static void main(String[] args) {

        RecursiveFunction_1 rf = new RecursiveFunction_1();
        rf.solution(3);
    }
}
