package HackerRank.RookieRank4;

import FastIO.InputReader;
import FastIO.OutputWriter;

class Node {
    int x;
    Node left;
    Node right;

    public Node()
    {
        this.x = 0;
        this.left = null;
        this.right = null;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

}

public class HeightAndTotalHeightOfABST {

    public static Node insert(Node root,int key){
        if(root == null)
        {
            Node node = new Node();
            node.setX(key);
            root = node;
        }
        if(key<root.getX())
            root.setLeft(insert(root.getLeft(),key));
        else if(key>root.getX())
            root.setRight(insert(root.getRight(),key));
        return root;
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        Node root =null ;
        for(int a:arr)
        {
            root = insert(root,a);
        }
        out.println(getHeight(root));
        out.println(preOrder(root));
    }

    public int getHeight(Node root)
    {
        if(root == null)
            return -1;
        return Math.max(getHeight(root.getLeft()),getHeight(root.getRight()))+1;
    }

    public int preOrder(Node root)
    {
        if(root == null )
            return 0;
        int l = preOrder(root.getLeft());
        int r = preOrder(root.getRight());
        return l+r+getHeight(root);
    }
}
