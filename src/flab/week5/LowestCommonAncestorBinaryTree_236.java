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
            // 재귀로 품
            // 1. root아래에 p,q가 전부존재한다면?  -->  root가 정답
            // 2. 둘다없다면 하위노드 검색
            // 3. 예를들어 p나q중에 1개만 찾았다면? --> 3-1) 반대편 노드에 나머지1개가 없을경우 찾은게 답
            //                                          3-2) 반대편 노드에 나머지1개가 있을경우 찾은거 위에 노드가 답

            if(root == null || root ==p || root== q) return root;
            // 1. root=3, p=5, q=1 --> TreeNode left로 접근 --> root=5, p=5, q=1 --> left=5;
            // 2. root=3, p=5, q=1 --> TreeNode right로 접근 --> root=1, p=5, q=1 --> right=1;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            // 왼쪽노드에 p 혹은 q가 있는지 확인  ex) p=5, q=4  둘다 왼쪽노드에 존재하고 둘중1개는 부모노드 left=5

            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // 오른쪽노드에 p 혹은 q가 있는지 확인  ex) p=5, q=4는 오른쪽 노드에 없으므로 right=null

            if(left == null) return right;  // p,q 둘다 오른쪽에 있고 둘중1개는 무조건 LCA
            else if(right ==null) return left;  // p,q 둘다 왼쪽에 있고 둘중1개는 무조건 LCA
            else return root;  // p,q가 왼쪽,오른쪽 1개씩 있다면 root가 LCA
        }
    }
}
