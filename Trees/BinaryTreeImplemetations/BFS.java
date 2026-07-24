package BinaryTreeImplemetations;


import java.util.*;

public class BFS {
    public static void main(String[] args) {
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
        levelOrder(a);
        System.out.println();

        iterativePreInPost(a);
    }

    private static void iterativePreInPost(Node node) {
        Stack<Pair> st = new Stack<>();
        String pre = "";
        String in = "";
        String post = "";
        Pair pair = new Pair(node, 1);
        st.push(pair);
        while (!st.isEmpty()) {
            Pair top = st.peek();
            if (top.state == 1) { //pre, state++, left
                pre += top.node.data + " ";
                top.state++;
                if (top.node.left != null) {
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                }
            } else if (top.state == 2) { //in , state++, right
                in += top.node.data + " ";
                top.state++;
                if (top.node.right != null) {
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                }
            } else {//post, pop
                post += top.node.data + " ";
                st.pop();
            }
        }
        System.out.println(pre);
        System.out.println(in);
        System.out.println(post     );
    }

    public static void levelOrder(Node node) {
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(node);
        while (!mq.isEmpty()) {
            int count = mq.size();
            for (int i = 0; i < count; i++) {
                node = mq.remove();
                System.out.print(node.data + " ");

                if (node.left != null)
                    mq.add(node.left);
                if (node.right != null)
                    mq.add(node.right);
            }
            System.out.println();
        }

    }

   private static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

   private static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;

        }
    }
}