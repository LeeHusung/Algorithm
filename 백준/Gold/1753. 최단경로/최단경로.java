import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int K = sc.nextInt();

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new int[]{v, w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{K, 0});

        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (p[1] > dist[p[0]]) continue;
            for (int[] x : graph.get(p[0])) {
//                if (x[1] > dist[x[0]]) continue;
                int cost = p[1] + x[1];
                if (dist[x[0]] > cost) {
                    dist[x[0]] = cost;
                    pq.offer(new int[]{x[0], cost});
                }
            }
        }
        dist[K] = 0;

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                System.out.println(dist[i]);
            } else {
                System.out.println("INF");
            }
        }


    }
}
