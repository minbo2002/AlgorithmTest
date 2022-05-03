package flab.week6;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals_56 {   // 정렬 알고리즘

    class Solution {
        public int[][] merge(int[][] intervals) {

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));   // .compare(a,b) : a>b이면 양수, a=b이면 0,  a<b이면 음수를 반환

            LinkedList<int[]> ans = new LinkedList<>();

            for(int[] tem : intervals) {

                // 처음이거나, ans마지막 인덱스에 들어있는 end값보다 다음번째 시작이 클경우
                if(ans.isEmpty() || ans.getLast()[1]<tem[0]) {
                    ans.add(tem);

                 // ans마지막 인덱스에 들어있는 end값이 시작값을 포함할때
                }else if(ans.getLast()[1] >= tem[0]) {
                    ans.getLast()[1] = Math.max(ans.getLast()[1], tem[1]);  // .getLast() : 리스트의 마지막 요소 반환
                }
            }

            return ans.toArray(new int[ans.size()][]);
        }
    }
}
