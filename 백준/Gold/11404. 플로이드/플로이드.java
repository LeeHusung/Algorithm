import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static int n, m;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

    private static int[] dijstra(int start) {
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (p[1] > res[p[0]]) continue;
            for (int[] x : graph.get(p[0])) {
                if (x[0] == start) continue;
                if (res[x[0]] > p[1] + x[1]) {
                    res[x[0]] = p[1] + x[1];
                    pq.offer(new int[]{x[0], p[1] + x[1]});
                }
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            graph.get(start).add(new int[]{end, cost});
        }


        for (int i = 1; i <= n; i++) {
            int[] res = dijstra(i);
//            StringBuilder sb = new StringBuilder();
            for (int j = 1; j < res.length; j++) {
                if (res[j] == Integer.MAX_VALUE) System.out.print(0 + " ");
                else System.out.print(res[j] + " ");
//                sb.append(res[j]).append(" ");
            }
            System.out.println();
        }


    }

}
