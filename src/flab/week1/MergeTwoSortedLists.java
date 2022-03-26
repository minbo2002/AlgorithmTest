package flab.week1;

/*

You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

ex1)
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

ex2)
Input: list1 = [], list2 = []
Output: []

ex3)
Input: list1 = [], list2 = [0]
Output: [0]

제약)
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class MergeTwoSortedLists {

    class Solution {

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode head = new ListNode();  // head 노드를 만든다
            ListNode handler = head;  //  head 노드의 주소를 가지는 handler 노드를 만든다

            while(l1 != null && l2 != null) {

                if (l1.val <= l2.val) {
                    handler.next = l1;
                    l1 = l1.next;
                } else {
                    handler.next = l2;
                    l2 = l2.next;
                }
                handler = handler.next;
            }

            if (l1 != null) {
                handler.next = l1;
            } else if (l2 != null) {
                handler.next = l2;
            }

            return head.next;
        }
    }
}
