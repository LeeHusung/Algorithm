import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (union(x, y)) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(0);

    }

    private static boolean union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx == fy) {
            return true;
        }
        if (fx < fy) {
            parent[fy] = fx;
        } else parent[fx] = fy;

        return false;
    }

    private static int find(int x) {
        if (x == parent[x]){
            return x;
        }
        return find(parent[x]);
    }
}
