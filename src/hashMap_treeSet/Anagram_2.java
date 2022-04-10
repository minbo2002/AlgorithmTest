package hashMap_treeSet;

/* 2. 아나그램 (HashMap)


* Anagram이란 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치하면 두 단어는 아나그램이라고 합니다.
  예를 들면 AbaAeCe 와 baeeACA 는 알파벳을 나열 순서는 다르지만 그 구성을 살펴보면 A(2), a(1), b(1), C(1), e(2)로
  알파벳과 그 개수가 모두 일치합니다. 즉 어느 한 단어를 재 배열하면 상대편 단어가 될 수 있는 것을 아나그램이라 합니다.
  길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램을 작성하세요.
  아나그램 판별시 대소문자가 구분됩니다.


* 입력 : 첫 줄에 첫 번째 단어가 입력되고, 두 번째 줄에 두 번째 단어가 입력됩니다.
        단어의 길이는 100을 넘지 않습니다.
        ex) AbaAeCe                    ex)  abaCC
            baeeACA                         Caaab

* 출력 : 두 단어가 아나그램이면 “YES"를 출력하고, 아니면 ”NO"를 출력합니다.
         ex) YES                       ex)  NO

첫줄의 단어를 HashMap에 넣고 두번째줄의 단어와 비교해가면서 있으면 1씩 감소시킨다.
AbaAeCe  key  | A | B | C | e |    baeeACA
        value | 3 | 1 | 1 | 2 |
 */

import java.util.HashMap;
import java.util.Scanner;

public class Anagram_2 {

    public String solution(String s1, String s2) {

        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();

        for(char x : s1.toCharArray()) {

            map.put(x, map.getOrDefault(x,0) + 1);
            System.out.println("s1 map : " + map);
        }
        for(char x : s2.toCharArray()) {

            if(!map.containsKey(x) || map.get(x)==0)  return "NO";
            // s1의 단어가 들어간 map의 key가 존재하지않거나  key의 value값을 감소시켜서 0을 만드려고했는데
            //                                          이미 value값이 0이여서 감소 시킬수없다면 "NO" 리턴

            //  .containsKey(key) : key가 존재하는지 확인. true / false 리턴
            //  .get(x) : x key에 있는 value값을 출력

            map.put(x, map.get(x)-1);
            System.out.println("s2 map : " + map);

        }

        return answer;
    }

    public static void main(String[] args) {

        Anagram_2 ana = new Anagram_2();
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(ana.solution(s1, s2));
    }
}
