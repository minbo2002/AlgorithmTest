package flab.week6;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {

    class LRUCache {
        // 시간복잡도 O(1)
        // doubled LinkedList  +  HashMap 사용
        // 같은값 입력되면 update하고 없는값을 찾으면 -1 반환하고
        // 용량이 가득차면 사용한지 오래된 순서대로 삭제
        public class Node {

            int key, value;
            Node prev, next;   // doubled LinkedList이므로  이전(previous)노드와 다음(next)노드로 구성되어있다.

            public Node(int key, int value) {
                this.key=key;
                this.value=value;
            }
        }

        Node head;
        Node tail;
        int capacity;
        Map<Integer, Node> map;

        //ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

        public LRUCache(int capacity) {
            head = null;
            tail = null;
            this.capacity=capacity;
            map = new HashMap<>();
        }

        public int get(int key) {
            if(!map.containsKey(key)) {   // .containsKey : key가 있으면 true 없으면 false
                return -1;

            }else {
                Node node = map.get(key);

                // head의 포인터 바꾸기
                if(node != head) {

                    if(node==tail) {
                        // 한칸 앞으로 tail 이동
                        tail=tail.prev;
                    }

                    // head로 node이동
                    //      head.... node.prev > node > node.next
                    // -->  node-head  ....  node.prev > node.next
                    if(node.prev != null) {
                        node.prev.next = node.next;
                    }
                    if(node.next != null) {
                        node.next.prev = node.prev;
                    }
                    node.next = head;
                    head.prev = node;
                    node.prev = null;
                    head = node;
                }

                return node.value;
            }
        }

        public void put(int key, int value) {
            if(get(key) == -1) {
                Node node = new Node(key, value);

                if(head == null) {
                    head = node;
                    tail = node;

                }else {
                    // head ......
                    // node > head .....
                    node.next = head;
                    head.prev = node;
                    head = node;
                }

                map.put(key, node);
                // evict tail
                // ...... tail.prev > tail
                // ...... tail.prev
                if(map.size() > capacity) {
                    map.remove(tail.key);
                    tail.prev.next = null;
                    tail = tail.prev;
                }

            }else {
                //update
                map.get(key).value = value;
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
