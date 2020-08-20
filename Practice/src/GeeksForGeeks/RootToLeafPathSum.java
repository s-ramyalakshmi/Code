package GeeksForGeeks;

/**
 * @author ramyalakshmi.s created on 2020-08-20
 */
public class RootToLeafPathSum {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        System.out.println(hasPathSum(root, 2));
        System.out.println(hasPathSum(root, 4));
    }

    private static boolean hasPathSum(Node root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null && sum - root.data == 0)
            return true;
        return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
    }
}
