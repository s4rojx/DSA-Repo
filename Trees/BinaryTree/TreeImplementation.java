package BinaryTree;

import java.util.*;

class Node {
    int val;
    Node left, right;

    public Node(int val) {
        this.val = val;
    }
}

class TreeImplementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(-1);
        Node d = new Node(1);
        Node e = new Node(2);
        Node f = new Node(6);
        Node g = new Node(9);
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        display(a);
        System.out.println();
        System.out.println("Size is: "+size(a));
        System.out.println("Sum is: "+sum(a));
        System.out.println("Levels are: "+levels(a));


    }

    private static int levels(Node root) {

        if (root == null)
            return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }

    private static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        return node.val + sum(node.left) + sum(node.right);
    }

    private static int size(Node node) {
        if (node == null)
            return 0;
        int leftSize = size(node.left);
        int rightSize = size(node.right);
        return 1 + leftSize + rightSize;

    }

    private static void display(Node a) {
        if (a == null)
            return;
        System.out.print(a.val + " ");
        display(a.left);
        display(a.right);
    }
}
