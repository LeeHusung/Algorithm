import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            graph.clear();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for (int i = 0; i <= n; i++) {
                graph.clear();
            }
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                graph.get(a).add(new int[]{b, d});
                graph.get(b).add(new int[]{a, d});
            }
            int[] sDijk = dijkstra(s);
            int[] gDijk = dijkstra(g);
            int[] hDijk = dijkstra(h);
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                int x = Integer.parseInt(br.readLine());
                if (sDijk[x] == sDijk[g] + gDijk[h] + hDijk[x] ||
                        sDijk[x] == sDijk[h] + hDijk[g] + gDijk[x]) {
                    res.add(x);
                }
            }
            Collections.sort(res);
            for (Integer i : res) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[] dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        int[] cost = new int[n + 1];
        for (int j = 0; j < cost.length; j++) {
            if (j == start) continue;
            cost[j] = Integer.MAX_VALUE;
        }
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            for (int[] z : graph.get(p[0])) {
                if (p[1] + z[1] < cost[z[0]]) {
                    cost[z[0]] = p[1] + z[1];
                    pq.offer(new int[]{z[0], z[1] + p[1]});
                }
            }
        }
        return cost;
    }

}
