package BinaryTree;

import java.util.*;
public class NodeToLeafPath {
    static ArrayList<Node> path = new ArrayList<>();
    static void main(String[] args) {
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
        int data = 9;
        int kk = 3;
        //System.out.println(rootToNode(a, data));
        //System.out.println(path);
        printKNodesFar(a, 7, 2);

    }
    private static void printKNodesFar(Node node, int data, int k) {
        path.clear();
        if (!rootToNode(node, data)) {
            System.out.println("Node not found");
            return;
        }
        Node block = null;
        for (int i = 0; i < path.size(); i++) {
            printKlevelDown(path.get(i), block, k - i);
            block = path.get(i);
        }
        System.out.println();
    }
    private static void printKlevelDown(Node node, Node block, int k) {
        if (node == null || node == block || k < 0) {
            return;
        }
        if (k == 0) {
            System.out.print(node.val + " ");
            return;
        }
        printKlevelDown(node.left, block, k - 1);
        printKlevelDown(node.right, block, k - 1);
    }
    // Given data find if data exist and print the path root to that node having that data ->
    public static boolean rootToNode(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.val == data) {
            path.add(node);
            return true;
        }
        boolean lc = rootToNode(node.left, data);
        if (lc) {
            path.add(node);
            return true;
        }
        boolean rc = rootToNode(node.right, data);
        if (rc) {
            path.add(node);
            return true;
        }
        return false;
    }
    static class Node {
        int val;
        Node left, right;
        public Node(int val) {
            this.val = val;
        }
    }

    public static class BFS {
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
            BFS.Node node;
            int state;

            Pair(BFS.Node node, int state) {
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
}