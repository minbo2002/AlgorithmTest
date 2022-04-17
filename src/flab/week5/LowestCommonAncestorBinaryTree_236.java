package flab.week5;

import flab.week3.TreeNode;

public class LowestCommonAncestorBinaryTree_236 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            // <풀이 아이디어>
            // 1. root아래에 p,q가 전부존재한다면?  -->  root가 정답
            // 2. 둘다없다면 하위노드 검색
            // 3. 예를들어 p나q중에 1개만 찾았다면? --> 3-1) 반대편 노드에 나머지1개가 없을경우 찾은게 답
            //                                          3-2) 반대편 노드에 나머지1개가 있을경우 찾은거 위에 노드가 답

            if(root == null || root ==p || root== q) return root;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if(left == null) return right;
            else if(right ==null) return left;
            else return root;
        }
    }
}
