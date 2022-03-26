package flab.week1;

/*
https://velog.io/@hyunjkluz/Leetcode%EB%A6%BF%EC%BD%94%EB%93%9C-2.-Add-Two-Numberes-Java

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
주어진 두 링크드 리스트의 역순으로 읽은 숫자들의 합을 역순으로 반환

ex1)
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807  -->  역순 [7, 0 ,8]

ex2)
Input: l1 = [0], l2 = [0]
Output: [0]

ex3)
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
Explanation: 9999999 + 9999 = 10009998  --> 역순 [8,9,9,9,0,0,0,1]

제약)
The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

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

public class AddTwoNumbers {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode node = new ListNode();
            ListNode result = node;
            int carry = 0;

            while (l1 != null || l2 != null) {  // l1, l2 둘다 null 이면 while문 빠져나감

                int sum = carry;   // sum 초기값 0

                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;   // .next  :  다음으로 이동
                }

                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }

                if (sum >= 10) {
                    node.next = new ListNode(sum - 10);
                    carry = 1;
                } else {
                    node.next = new ListNode(sum);
                    carry = 0;
                }

                node = node.next;
            }

            if (carry == 1) {
                node.next = new ListNode(1);
            }

            return result.next;

        }
    }
}
