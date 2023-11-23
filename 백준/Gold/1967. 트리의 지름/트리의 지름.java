import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int n;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph.get(x).add(new int[]{y, z});
            graph.get(y).add(new int[]{x, z});
        }

        int answer = 0;
        int firstDjik = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // 다익스트라 알고리즘 수행 (임의의 노드에서 가장 거리가 먼 노드 찾기)
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        pq.offer(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (p[1] > dist[p[0]]) continue;
            for (int[] x : graph.get(p[0])) {
                int cost = p[1] + x[1];
                if (cost < dist[x[0]]) {
                    dist[x[0]] = cost;
                    pq.offer(new int[]{x[0], cost});
                }
            }
        }
        int max = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                if (dist[i] > max) {
                    max = dist[i];
                    firstDjik = i;
                }
            }
        }

// 다익스트라 알고리즘 수행 (가장 거리가 먼 노드에서 가장 거리가 먼 노드 찾기)
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[firstDjik] = 0;
        pq.offer(new int[]{firstDjik, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (p[1] > dist[p[0]]) continue;
            for (int[] x : graph.get(p[0])) {
                int cost = p[1] + x[1];
                if (cost < dist[x[0]]) {
                    dist[x[0]] = cost;
                    pq.offer(new int[]{x[0], cost});
                }
            }
        }
        int max2 = 0;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                max2 = Math.max(max2, dist[i]);
            }
        }
        answer = max2;

        System.out.println(answer);
    }
}
