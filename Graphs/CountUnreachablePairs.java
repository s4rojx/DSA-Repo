import java.util.*;

public class CountUnreachablePairs {
    static ArrayList<ArrayList<Integer>> g;
    static int visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        g = new ArrayList<>();
        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }
    }

    private static void solve(Scanner sc) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        g.clear();
        for (int i = 0; i <= n; i++) {
            g.add(new ArrayList<>());
        }
        visited = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            g.get(a).add(b);
            g.get(b).add(a);
        }
        int compCount = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                compCount++;
                dfs(i, compCount);
            }
        }
        int[] size = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            size[visited[i]]++;
        }
        long ans = 0;
        long sum = 0;
        for (int i = 0; i <= compCount; i++) {
            ans += (long) size[i] * sum;
            sum += size[i];
        }
        System.out.println(ans);
    }

    private static void dfs(int node, int compCount) {
        visited[node] = compCount;
        for (int v : g.get(node)) {
            if (visited[v] == 0) {
                dfs(v, compCount);
            }
        }
    }
}