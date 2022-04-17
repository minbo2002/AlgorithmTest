import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DsgTest2 {

    //  중복 판별

    private int solution(String str) {
        // map + 최대값 + count
        int answer = 0;

        int max = Integer.MIN_VALUE;

        Map<Character, Integer> map = new HashMap<>();

        for (char key : str.toCharArray()) {
            map.put(key, map.getOrDefault(key, 0) + 1);
            if (map.get(key) > max) {
                max = map.get(key);
                answer = max;
            }
        }


        return answer;
    }

    public static void main(String[] args) {

        DsgTest2 T = new DsgTest2();

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }



}
