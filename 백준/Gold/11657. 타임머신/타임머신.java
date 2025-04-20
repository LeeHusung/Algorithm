import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static Bus[] buses;
    static long[] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        buses = new Bus[m];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            buses[i] = new Bus(a, b, c);
        }

        cost = new long[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        if (Bellmanford(1)) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i < cost.length; i++) {
                if (cost[i] == Integer.MAX_VALUE) {
                    sb.append(-1).append("\n");
                } else sb.append(cost[i]).append("\n");
            }
            System.out.println(sb);
        }


    }

    private static boolean Bellmanford(int start) {
        cost[start] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int from = buses[j].from;
                int to = buses[j].to;
                int val = buses[j].val;
                if (cost[from] == Integer.MAX_VALUE) continue;
                if (cost[to] > cost[from] + val) {
                    cost[to] = cost[from] + val;
                    if (i == n - 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static class Bus {
        int from;
        int to;
        int val;

        public Bus(int from, int to, int val) {
            this.from = from;
            this.to = to;
            this.val = val;
        }
    }
}
