import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n - 2; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            union(x, y);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (parent[i] == i) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx < fy) {
            parent[fy] = fx;
        } else {
            parent[fx] = fy;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        else {
            return parent[x] = find(parent[x]);
        }
    }
}
