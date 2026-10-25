import java.util.*;

public class GridBFS {
    static class Pair {
        int f, s; // f = first (row), s = second (column)
        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
    // Grid dimensions and storage
    static int n, m;
    static String[] arr;
    static int[][] dist;
    static Pair[][] par;
    // Movement vectors for 4-directional movement (Down, Right, Up, Left)
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    // Check if position (x, y) is within bounds and not a wall
    static boolean check(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < m && arr[x].charAt(y) != '#') {
            return true;
        }
        return false;
    }

    // Recursively prints the path from Start to End
    static void ppath(Pair en) {
        if (en.f == -1 && en.s == -1) return;
        ppath(par[en.f][en.s]);
        System.out.println(en.f + " " + en.s);
    }

    // BFS algorithm to find shortest distances and track parents
    static void bfs(Pair st) {
        Queue<Pair> q = new LinkedList<>();

        dist = new int[n][m];
        par = new Pair[n][m];

        // Initialize distances to a large value (infinity)
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], (int) 1e9);
        }

        dist[st.f][st.s] = 0;
        par[st.f][st.s] = new Pair(-1, -1);
        q.add(st);

        while (!q.isEmpty()) {
            Pair pos = q.poll();

            for (int k = 0; k < 4; k++) {
                int nx = pos.f + dx[k];
                int ny = pos.s + dy[k];

                if (check(nx, ny) && dist[nx][ny] > dist[pos.f][pos.s] + 1) {
                    dist[nx][ny] = dist[pos.f][pos.s] + 1;
                    par[nx][ny] = new Pair(pos.f, pos.s);
                    q.add(new Pair(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Pair st = new Pair(sc.nextInt(), sc.nextInt());
        Pair en = new Pair(sc.nextInt(), sc.nextInt());

        bfs(st);

        // Print distance
        System.out.println("Distance: " + dist[en.f][en.s]);

        // Print path
        if (dist[en.f][en.s] != (int) 1e9) {
            ppath(en);
        } else {
            System.out.println("No path found");
        }

        sc.close();
    }
}