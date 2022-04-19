package flab.week5;

import flab.week3.TreeNode;

import java.util.ArrayDeque;

public class SerializeDeserializeBinaryTree_297 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        public ArrayDeque<TreeNode> dq = new ArrayDeque<>(10000);
        // ArrauDeque<> 클래스 :  사이즈제한없음. 멀티쓰레드안됨. null 저장안됨. Stack, LinkedList보다 빠름.

        public StringBuilder sb = new StringBuilder("[");


        public String serialize(TreeNode root) {
            // serialize : 논리적인 데이터구조를 --> 물리적인 데이터구조로 변경

            if(root != null){
                sb.append(Integer.toString(root.val));  // .append() :  인수값 문자열 변환후 이어붙임                         // 숫자+부호 = 유니코드값으로 변환되어 처리되는 경우가 생기므로 Interger.toString 사용할것
                dq.add(root);
                TreeNode temp;
                while(!dq.isEmpty()) {
                    temp = dq.poll();

                    // left
                    sb.append(",");
                    if (temp.left == null) sb.append("null");
                    else {
                        sb.append(Integer.toString(temp.left.val));
                        dq.add(temp.left);
                    }

                    //right
                    sb.append(",");
                    if (temp.right == null) sb.append("null");
                    else {
                        sb.append(Integer.toString(temp.right.val));
                        dq.add(temp.right);
                    }
                }
            }
            sb.append("]");
            return sb.toString();
        }


        // util 함수
        public TreeNode createNode(String str){
            return new TreeNode(Integer.parseInt(str));
        }
        public ArrayDeque<TreeNode> deque = new ArrayDeque<>(10000);
        public String[] arr;


        public TreeNode deserialize(String data) {
            // deserialize : 물리적인 데이터구조를 --> 논리적인 데이터구조로 변경

            // [] 인 경우
            if(data.length()==2) return null;
            data = data.substring(1,data.length()-1);
            arr = data.split(",");
            int idx = 0;
            TreeNode root = createNode(arr[idx++]);
            TreeNode temp;
            deque.add(root);

            while(idx < arr.length){
                temp = deque.poll();
                // left
                if(arr[idx].equals("null"));
                else{
                    temp.left = createNode(arr[idx]);
                    deque.add(temp.left);
                }
                idx++;
                //right
                if(arr[idx].equals("null"));
                else{
                    temp.right = createNode(arr[idx]);
                    deque.add(temp.right);
                }
                idx++;
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
