package flab.week5;

/*
ex1) input [[0, 30], [5,10], [15,20]]
     output 2

ex2) input [[7,10], [2,4]]
     output 1

1. Interval 객체가 담긴 배열을 시작시간 오름차순으로 정렬

2. 종료시간 오름차순으로 하는 PriorityQueue 생성

3. Interval 배열을 순서대로 돌면서 PriorityQueue에 가장 빨리 끝나는 회의 시간이
   이번 Interval 시작시간과 같거나 먼저끝나면 PriorityQueue의 가장빨리 끝나는 회의 제거하고
   (같은 회의실에서 진행 할 수 있으므로 1개의 회의실만 필요)
   PriorityQueue에 이번 Interval 추가

4. PriorityQueue 크기 반환

https://the-dev.tistory.com/51

 */

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms_253 {

    public int minMeetingRooms(Interval[] intervals) {

        Arrays.sort(intervals, (a,b)-> a.start-b.start);  // ASC
        // 0,30   5,15    15,25   20,30

        Queue<Interval> endtimeQueue = new PriorityQueue<>( (a,b) -> a.end-b.end);  // ASC
        // 5,15   15,25   0,30   20,30

        for(Interval interval : intervals) {
            if(!endtimeQueue.isEmpty() && endtimeQueue.peek().end <= interval.start) {
                endtimeQueue.poll();   // .poll() : 값을 빼낸다
            }

            endtimeQueue.offer(interval);   // .offer() : 값을 넣는다다
       }

        return endtimeQueue.size();
    }

    public static void main(String[] args) {

        Interval[] intervals = new Interval[] {
            new Interval(15, 25),
            new Interval(0, 30),
            new Interval(5, 15),
            new Interval(20, 30)
        };

        MeetingRooms_253 m = new MeetingRooms_253();
        System.out.println(m.minMeetingRooms(intervals));
    }
}
