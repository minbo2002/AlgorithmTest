package recursive_tree_graph;

/*

5. 이진트리 순회 (DFS : Depth First Search)

설명 : 아래 그림과 같은 이진트리를
      전위순회(부모노드 -> 왼쪽노드 -> 오른쪽노드 순서),
      중위순회(왼쪽노드 -> 부모노드 -> 오른쪽노드 순서),
      후위순회(왼쪽노드 -> 오른쪽노드 -> 부모노드 순서)로 연습해라

            1
        2       3
      4   5   6   7


출력 : 전위순회  1 2 4 5 3 6 7
      중위순회  4 2 5 1 6 3 7
      후위순회  4 5 2 6 7 3 1

*/

public class BinaryTreeTour_5 {

    static class Node {   //                            |---------|
                   //                                   |    1    |
        int data;  // 번호 1,2,3,4,.... 쓰는 용도         |---------|  Node 클래스 객체를 만들경우
        Node lt, rt;  // 왼쪽노드, 오른쪽노드 주소          | lt | rt |  lt, rt는 객체주소를 저장하는 인스턴스변수
                      //                                |-------- |
        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    Node root;  // 인스턴스변수
    public void DFS(Node root) {  // DFS 라는 이름의 메소드.  root 변수는 1번 데이터 Node(1)를 가지고있음

        if(root == null) {
            return;  // root가 null이면 말단노드까지 온것

        }else {
        //    System.out.print(root.data + " ");  // 전위순회
            DFS(root.lt);
        //    System.out.print(root.data + " ");  // 중위순회
            DFS(root.rt);
            System.out.print(root.data + " ");  // 후위순회
        }
    }

    public static void main(String[] args) {

        BinaryTreeTour_5 tree = new BinaryTreeTour_5();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.DFS(tree.root);
    }
}
