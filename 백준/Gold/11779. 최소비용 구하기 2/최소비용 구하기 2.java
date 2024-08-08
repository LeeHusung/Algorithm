import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] cost;
    static int res;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static LinkedList<Integer> list = new LinkedList<>();
    static int start, end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(s).add(new int[]{e, c});
        }
        String[] s = br.readLine().split(" ");
        start = Integer.parseInt(s[0]);
        end = Integer.parseInt(s[1]);

        cost = new int[n + 1];
        int[] root = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (p[0] == end) break;
            if (cost[p[0]] < p[1]) continue;
            for (int[] x : graph.get(p[0])) {
                if (cost[x[0]] > x[1] + p[1]) {
                    cost[x[0]] = x[1] + p[1];
                    pq.offer(new int[]{x[0], cost[x[0]]});
                    root[x[0]] = p[0];
                }
            }
        }
        System.out.println(cost[end]);

        int res = end;
        while (res != 0) {
            list.add(res);
            res = root[res];
        }
        System.out.println(list.size());
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);

    }

}
