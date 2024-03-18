import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(x).add(new int[]{y, cost});
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 1; i <= n; i++) {
            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            pq.offer(new int[]{i, 0});
            while (!pq.isEmpty()) {
                int[] p = pq.poll();
                
                if (dist[p[0]] < p[1]) continue;
                for (int[] x : graph.get(p[0])) {
                    if (x[0] == i) continue;
                    if (dist[x[0]] > x[1] + p[1]) {
                   
                        dist[x[0]] = x[1] + p[1];
                        pq.offer(new int[]{x[0], x[1] + p[1]});
                    }
                }
            }
            for (int j = 1; j < dist.length; j++) {
                if (i == j || dist[j] == Integer.MAX_VALUE) {
                    sb.append(0).append(" ");
                    continue;
                }
                sb.append(dist[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}