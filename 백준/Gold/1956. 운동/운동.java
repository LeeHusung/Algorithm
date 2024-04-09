import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int v, e;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        v = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        int answer = Integer.MAX_VALUE;

        StringTokenizer st;
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, c});
        }

        for (int i = 1; i <= v; i++) {
            int min = dijkstra(i);
            answer = Math.min(answer, min);
        }
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else System.out.println(answer);

    }

    private static int dijkstra(int num) {
        int[] dist = new int[v + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.offer(new int[]{num, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (dist[p[0]] < p[1]) continue;
            for (int[] x : graph.get(p[0])) {
                if (p[1] + x[1] < dist[x[0]]) {
                    dist[x[0]] = p[1] + x[1];
                    pq.offer(new int[]{x[0], p[1] + x[1]});
                }
            }
        }
        return dist[num];
    }

}
