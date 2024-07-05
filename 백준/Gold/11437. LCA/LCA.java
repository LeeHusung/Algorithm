import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int n;
    static int[] parent, depth;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        depth = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        set(1, 1, 0);
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            sb.append(LCA(a, b)).append("\n");
        }
        System.out.println(sb);
    }

    private static void set(int cur, int d, int p) {
        parent[cur] = p;
        depth[cur] = d;
        for (Integer x : graph.get(cur)) {
            if (x == p) continue;
            set(x, d + 1, cur);
        }
    }

    private static int LCA(int x, int y) {
        int px = depth[x];
        int py = depth[y];
        while (px < py) {
            y = parent[y];
            py--;
        }
        while (px > py) {
            x = parent[x];
            px--;
        }
        while (true) {
            if (x == y) return x;
            x = parent[x];
            y = parent[y];
        }
    }
}
