import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int cost = sc.nextInt();
            graph.get(x).add(new int[]{y, cost});
        }
        int start = sc.nextInt();
        int end = sc.nextInt();

        int[][] dist = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == j) dist[i][j] = 0;
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});

        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (p[1] > dist[start][p[0]]) continue;
            for (int[] x : graph.get(p[0])) {
                int cost = p[1] + x[1];
                if (dist[start][x[0]] > cost) {
                    dist[start][x[0]] = cost;
                    q.offer(new int[]{x[0], cost});
                }
            }
        }
        System.out.println(dist[start][end]);

    }
}
