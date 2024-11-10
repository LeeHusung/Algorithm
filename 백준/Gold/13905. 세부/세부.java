import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, s, e;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int[] parents;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        s = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);
        arr = new int[m][3];
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr[i][0] = h1;
            arr[i][1] = h2;
            arr[i][2] = k;
        }
        Arrays.sort(arr, (a, b) -> b[2] - a[2]);

        for (int i = 0; i < m; i++) {
            int h1 = arr[i][0];
            int h2 = arr[i][1];
            if (find(h1) == find(h2)) continue;
            union(h1, h2);
            graph.get(h1).add(new int[]{h2, arr[i][2]});
            graph.get(h2).add(new int[]{h1, arr[i][2]});
        }
        int[] ch = new int[n + 1];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        int min = Integer.MAX_VALUE;
        q.offer(new int[]{s, Integer.MAX_VALUE});
        ch[s] = 1;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            min = Math.min(min, p[1]);
            if (p[0] == e) {
                System.out.println(min);
                return;
            }
            for (int[] x : graph.get(p[0])) {
                if (ch[x[0]] == 0) {
                    ch[x[0]] = 1;
                    q.offer(x);
                }
            }
        }
        System.out.println(0);

    }

    private static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx < fy) {
            parents[fy] = fx;
        } else parents[fx] = fy;
    }

    private static int find(int x) {
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
}
