import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int d = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);

            ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph.get(b).add(new int[]{a, s});
            }

            int[] cost = new int[n + 1];
            Arrays.fill(cost, Integer.MAX_VALUE);
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            q.offer(new int[]{c, 0});
            cost[c] = 0;

            while (!q.isEmpty()) {
                int[] p = q.poll();
                int current = p[0];
                int currentCost = p[1];

                if (currentCost > cost[current]) continue;

                for (int[] x : graph.get(current)) {
                    int next = x[0];
                    int nextCost = currentCost + x[1];

                    if (nextCost < cost[next]) {
                        cost[next] = nextCost;
                        q.offer(new int[]{next, nextCost});
                    }
                }
            }

            int cnt = 0;
            int sec = 0;
            for (int i = 1; i <= n; i++) {
                if (cost[i] != Integer.MAX_VALUE) {
                    cnt++;
                    sec = Math.max(sec, cost[i]);
                }
            }
            sb.append(cnt).append(" ").append(sec).append("\n");
        }
        System.out.println(sb);
    }
}
