import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int n, m, x;
    static int[] dist;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>(), backGraph = new ArrayList<>();
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        x = Integer.parseInt(input[2]);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            backGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            graph.get(start).add(new int[]{end, cost});
            backGraph.get(end).add(new int[]{start, cost});
        }

        int[] go = dijkstra(graph);
        int[] back = dijkstra(backGraph);
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            max = Math.max(max, go[i] + back[i]);
        }
        System.out.println(max);
    }

    private static int[] dijkstra(ArrayList<ArrayList<int[]>> graph) {
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        pq.offer(new int[]{x, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (p[1] > cost[p[0]]) continue;
            for (int[] x : graph.get(p[0])) {
                if (cost[x[0]] > p[1] + x[1]) {
                    cost[x[0]] = p[1] + x[1];
                    pq.offer(new int[]{x[0], x[1] + p[1]});
                }
            }
        }
        return cost;
    }
}