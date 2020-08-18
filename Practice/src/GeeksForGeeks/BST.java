package GeeksForGeeks;

/**
 * @author ramyalakshmi.s created on 2020-08-18
 */
class Nodes {
    int data;
    Nodes left;
    Nodes right;
    Nodes(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
public class BST {
    public static void main(String[] args) {
        Nodes tree1 = new Nodes(2);
        tree1.left = new Nodes(1);
        tree1.right = new Nodes(3);
        System.out.println(isBST(tree1));
    }

    private static boolean isBST(Nodes tree1) {
        return isBST(tree1, null, null);
    }

    private static boolean isBST(Nodes root, Nodes left, Nodes right) {
        if(root == null)
            return true;

        if(left != null && root.data <= left.data)
            return false;

        if(right != null && root.data >= right.data)
            return false;

        return ((isBST(root.left, left, root)) && isBST(root.right, root, right));
    }
}
