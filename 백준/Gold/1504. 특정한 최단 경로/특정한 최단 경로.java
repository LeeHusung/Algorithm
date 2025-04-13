import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, e, t1, t2;
    static final int INF = 1_000_000_000;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }
        s = br.readLine().split(" ");
        t1 = Integer.parseInt(s[0]);
        t2 = Integer.parseInt(s[1]);

        int common = dijkstra(t1, t2);
        if (common == -1) {
            System.out.println(-1);
            return;
        }
        int path1 = add(dijkstra(1, t1), dijkstra(t1, t2), dijkstra(t2, n));
        int path2 = add(dijkstra(1, t2), dijkstra(t2, t1), dijkstra(t1, n));

        if (path1 == -1 && path2 == -1) {
            System.out.println(-1);
        } else if (path1 == -1) {
            System.out.println(path2);
        } else if (path2 == -1) {
            System.out.println(path1);
        } else {
            System.out.println(Math.min(path1, path2));
        }

    }
    private static int add(int a, int b, int c) {
        if (a == -1 || b == -1 || c == -1) return -1;
        return a + b + c;
    }


    private static int dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        int[] cost = new int[n + 1];
        Arrays.fill(cost, INF);
        cost[start] = 0;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (cost[p[0]] > p[1]) continue;
            for (int[] x : graph.get(p[0])) {
                if (p[1] + x[1] < cost[x[0]]) {
                    cost[x[0]] = x[1] + p[1];
                    pq.offer(new int[]{x[0], x[1] + p[1]});
                }
            }
        }
        if (cost[end] == INF) {
            return -1;
        }
        return cost[end];
    }
}
