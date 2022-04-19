package flab.week5;

import flab.week3.TreeNode;

/*
https://leetcode.com/problems/diameter-of-binary-tree/
 */

public class DiameterBinaryTree_543 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {  // 재귀로 푼다 (root를 움직인다고 가정)

        public int max=0;

        public int diameterOfBinaryTree(TreeNode root) {
            getMaxDepth(root);

            return max;
        }

        private int getMaxDepth(TreeNode root) {  // 리프노드부터 시작해서
            // 각각의 노드를 루트노드라고 가정하고 최대 max를 구한다.
            if (root == null) {
                return 0;
            }

            int left = getMaxDepth(root.left);      // 왼쪽 노드에 대해서 최대깊이 탐색
            int right = getMaxDepth(root.right);    // 오른쪽 노드에 대해서 최대깊이 탐색
            max = Math.max(max, left + right);      // 양쪽 노드에 대해서 최대 깊이 갱신

            return Math.max(left, right) + 1;   // 재귀 종료조건
            // 리프노드인 4 입장에서 보면 left=0, right=0이고
            // Math.max(left, right)  -->  Math.max(0, 0) = 0 이고
            // 리프노드인 4의 부모노드인 2로 가기위한 에지가 1개이므로
            // Math.max(0, 0) + 1 = 1 이라는 뜻이다.
        }
    // root=1일때 int left=2, int right=1, max=Math.max(0, 2+1)=3  -->  return Math.max(2, 1) + 1 = 3
    // root=2일때 int left=1, int right=1, max=Math.max(3, 1+1)=3  -->  return Math.max(1, 1) + 1 = 2
    // root=3일때 int left=0, int right=0, max=Math.max(3, 0+0)=3  -->  return Math.max(0, 0) + 1 = 1
    // root=4일때 int left=0, int right=0, max=Math.max(3, 0+0)=3  -->  return Math.max(0, 0) + 1 = 1
    // root=5일때 int left=0, int right=0, max=Ma -->  return Math.max(0, 0) + 1 = 1
    }
}
