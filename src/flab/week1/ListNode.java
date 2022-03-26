package flab.week1;

public class ListNode {

        int val;        // Linked list의 값
        ListNode next;  // Linked list의 pointer

//  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
// | value | pointer |

        ListNode() {   // 기본생성자

        }

        ListNode(int val) {   // 생성자

            this.val = val;
        }

        ListNode(int val, ListNode next) {   // 생성자
            this.val = val;
            this.next = next;
        }

}
