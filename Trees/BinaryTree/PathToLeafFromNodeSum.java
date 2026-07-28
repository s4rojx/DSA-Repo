package BinaryTree;

import java.util.*;

public class PathToLeafFromNodeSum {
    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(5);
        Node c = new Node(15);
        Node d = new Node(3);
        Node e = new Node(7);
        Node f = new Node(12);
        Node g = new Node(18);
        Node h = new Node(1);
        Node i = new Node(4);
        Node j = new Node(6);
        Node k = new Node(8);
        Node l = new Node(11);
        Node m = new Node(13);
        Node n = new Node(17);
        Node o = new Node(20);
// Level 1
        a.left = b;
        a.right = c;
// Level 2
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
// Level 3
        d.left = h;
        d.right = i;
        e.left = j;
        e.right = k;
        f.left = l;
        f.right = m;
        g.left = n;
        g.right = o;
        pathToLeafFromRoot(a, "", 0, 20, 50);
    }

    //Sum function
    public static int sumOfNode(Node node) {
        if (node == null) {
            return 0;
        }
        int leftSum = sumOfNode(node.left);
        int rightSum = sumOfNode(node.right);
        return node.data + leftSum + rightSum;
    }

    // Tilt
    public static int tilt(Node node) {
        if (node == null) {
            return 0;
        }
        int left = tilt(node.left);
        int right = tilt(node.right);
        int sum = Math.abs(sumOfNode(node.left) - sumOfNode(node.right));
        return sum + left + right;
    }

    public static void pathToLeafFromRoot(Node node, String path, int sum, int lo, int hi) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            sum += node.data;
            if (sum >= lo && sum <= hi) {
                System.out.println(path + node.data);
            }
            return;
        }
        pathToLeafFromRoot(node.left, path + node.data + " ", sum + node.data, lo, hi);
        pathToLeafFromRoot(node.right, path + node.data + " ", sum + node.data, lo, hi);
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
}