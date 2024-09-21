import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int idx = 1;
        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                String[] s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                union(a, b);
            }

         
            sb.append("Scenario ").append(idx++).append(":").append("\n");
            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                String[] s = br.readLine().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                if (find(u) == find(v)) {
                    sb.append(1).append("\n");
                } else sb.append(0).append("\n");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx > fy) {
            parent[fx] = fy;
        } else parent[fy] = fx;
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
