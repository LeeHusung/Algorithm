import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
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

        String[] s = br.readLine().split(" ");
        int startPoint = Integer.parseInt(s[0]);
        int endPoint = Integer.parseInt(s[1]);

        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{startPoint, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (p[1] > res[p[0]]) continue;
            for (int[] x : graph.get(p[0])) {
                if (res[x[0]] > x[1] + p[1]) {
                    res[x[0]] = x[1] + p[1];
                    pq.offer(new int[]{x[0], x[1] + p[1]});
                }
            }
        }
        System.out.println(res[endPoint]);

    }
}
