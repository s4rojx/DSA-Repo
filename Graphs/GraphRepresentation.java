import java.util.*;

public class GraphRepresentation {
    private static int dest;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }
        int edges = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < edges; i++) {
            String[] parts = sc.nextLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        int src = sc.nextInt();
        int dest = sc.nextInt();
        boolean[] visited = new boolean[vertices];
        System.out.println(hasPath(graph, src, dest, visited));

    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {

        if (src == dest) {
            return true;
        }

        visited[src] = true;

        for (Edge edge : graph[src]) {

            if (!visited[edge.nbr]) {
                boolean hasNbrPath = hasPath(graph, edge.nbr, dest, visited);

                if (hasNbrPath) {
                    return true;
                }
            }
        }

        return false;
    }
    public static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
}