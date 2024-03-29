import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
        int[][] arr = new int[m][3];
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            int cost = Integer.parseInt(s1[2]);
            arr[i][0] = x;
            arr[i][1] = y;
            arr[i][2] = cost;
        }

        Arrays.sort(arr, (a, b) -> a[2] - b[2]);

        int answer = 0;
        int max = 0;
        for (int[] x : arr) {
            if (parent[x[0]] == parent[x[1]]) continue;
            int fx = find(x[0]);
            int fy = find(x[1]);
            if (fx == fy) continue;
            max = Math.max(max, x[2]);
            answer += x[2];
            union(fx, fy);
        }
        System.out.println(answer - max);

    }

    private static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx > fy) parent[fx] = fy;
        else parent[fy] = fx;
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
