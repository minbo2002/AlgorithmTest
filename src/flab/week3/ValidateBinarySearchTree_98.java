package flab.week3;

/*
https://velog.io/@6047198844/leetcode-Validate-Binary-Search-Tree
참고
 */

import java.util.Stack;

public class ValidateBinarySearchTree_98 {  // 이진트리 문제

    class Solution {

        public boolean isValidBST(TreeNode root) {
            // 이진트리 : 노드의 왼쪽보다 크고 오른쪽보다 작다
            // 가장작은 키는 맨 아래의 맨 왼쪽. 가장 큰 키는 맨 아래의 맨 오른쪽
            return helper(root, null, null);
        }

        boolean helper(TreeNode root, Integer min, Integer max) {  // 재귀함수
            if (root == null)
                return true;

            if ((min != null && root.val <= min) || (max != null && root.val >= max))
                return false;  // 이진트리가 성립되지 않는 조건

            return helper(root.left, min, root.val) && helper(root.right, root.val, max);
        }

        ////////////////////////////////////////////////////////////

        public boolean isValidBST_2(TreeNode root) {

            if(root == null)
                return true;

            Stack<TreeNode> stack = new Stack<>();

            TreeNode pre = null;

            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if(pre != null && root.val <= pre.val)
                    return false;

                pre = root;
                root = root.right;
            }

            return true;
        }
    }
}
