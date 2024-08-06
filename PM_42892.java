//https://school.programmers.co.kr/learn/courses/30/lessons/42892
//programmers - 길찾기 게임

import java.util.*;

class Solution {


    class Node {
        int x, y, idx;
        Node left, right;

        Node(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }


    List<Integer> preorderList = new ArrayList<>();
    List<Integer> postorderList = new ArrayList<>();


    public int[][] solution(int[][] nodeinfo) {

        int n = nodeinfo.length; //node 개수
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }

        /**node 정렬
         * 1. y 기준 내림차순
         * 2. x 기준 오름차순
         */
        Arrays.sort(nodes, (a, b) -> {
            if (a.y == b.y) {
                return a.x - b.x;
            }
            return b.y - a.y;
        });

        //root node 지정
        Node root = nodes[0];

        //root node 를 기준으로 node 순서대로 삽입
        for (int i = 1; i < n; i++) {
            insertNode(root, nodes[i]);
        }

        preorder(root); //전위 순회
        postorder(root); //후위 순회

        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = preorderList.get(i);
            answer[1][i] = postorderList.get(i);
        }
        
        return answer;
    }


    private void insertNode(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }


    //전위 순회
    private void preorder(Node node) {
        if (node == null) return;
        preorderList.add(node.idx); //현재노드 방문
        preorder(node.left); //왼쪽 자식 방문
        preorder(node.right); //오른쪽 자식 방문
    }

    //후위 순회
    private void postorder(Node node) {
        if (node == null) return;
        postorder(node.left); //왼쪽 자식 방문
        postorder(node.right); //오른쪽 자식 방문
        postorderList.add(node.idx); //현재노드 방문
    }
}