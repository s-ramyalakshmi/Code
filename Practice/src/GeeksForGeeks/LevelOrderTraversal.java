package GeeksForGeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ramyalakshmi.s created on 2020-08-09
 */

//url : https://practice.geeksforgeeks.org/problems/level-order-traversal/1
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class LevelOrderTraversal {

    static ArrayList<Integer> levelOrder(Node node)
    {
        // Your code here
        Queue<Node> que = new LinkedList<Node>();
        ArrayList<Integer> res = new ArrayList<>();
        que.add(node);
        while(!que.isEmpty()) {
            Node temp = que.poll();
            res.add(temp.data);
            if(temp.left != null)
                que.add(temp.left);
            if(temp.right != null)
                que.add(temp.right);
        }

        return res;
    }

}
