import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class DFS_BFS_Test {

  static class Node {
    int idx;
    Node leftNode, rightNode;
  
    public Node(int idx) {
      this.idx = idx;
    }
  }


  public static void main(String[] args) {

    
    Node root = new Node(0);
    root.leftNode = new Node(1);
    root.rightNode = new Node(2);

    root.leftNode.leftNode = new Node(3);
    root.leftNode.rightNode = new Node(4);

    root.rightNode.leftNode = new Node(5);
    root.rightNode.rightNode = new Node(6);

    System.out.print("DFS : ");
    DFS(root);
    System.out.println();
    System.out.print("BFS : ");
    BFS(root);
  }

  private static void DFS(Node root) {
    if (root == null) return;
    System.out.print(root.idx + " ");
    DFS(root.leftNode);
    DFS(root.rightNode);
  }

  private static void BFS(Node root) {
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);

    //BFS 탐색
    while (!queue.isEmpty()) {
      Node current = queue.poll();
      if (current != null) {
        System.out.print(current.idx + " ");
        queue.add(current.leftNode);
        queue.add(current.rightNode);
      }
    }
  }

}
