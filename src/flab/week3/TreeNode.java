package flab.week3;

public class TreeNode {

    public int val;  // 값을 저장할 변수

    public TreeNode left;  // 왼쪽 연결 노드 정보를 저장할 변수
    public TreeNode right; // 오른쪽 연결 노드 정보를 저장할 변수

    TreeNode() {

    }

    public TreeNode(int val) {

       this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
       this.right = right;
    }
}
