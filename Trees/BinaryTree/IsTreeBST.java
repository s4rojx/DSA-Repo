package BinaryTree;

import java.util.*;

public class IsTreeBST {
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
        System.out.println(isBST(a));
// Root
    }
    public static boolean isBST(Node node){
        if(node == null){
            return true;
        }
        List<Integer> list = new ArrayList<>();
        inOrder(node, list);
        int prev = list.getFirst();
        for(int i = 1;i<list.size();i++){
            if(list.get(i) <= prev){
                return false;
            }
            prev = list.get(i);
        }
        return true;

    }

    public static void inOrder(Node node, List<Integer> list ){
        if(node == null){
            return ;
        }
        inOrder(node.left, list);
        list.add(node.data);
        inOrder(node.right, list);

    }

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

}