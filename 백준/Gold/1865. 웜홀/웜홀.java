import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            ArrayList<Edge> graph = new ArrayList<>();
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            for (int j = 0; j < m; j++) {
                String[] z = br.readLine().split(" ");
                int s = Integer.parseInt(z[0]);
                int e = Integer.parseInt(z[1]);
                int t = Integer.parseInt(z[2]);
                graph.add(new Edge(s, e, t));
                graph.add(new Edge(e, s, t));
            }
            for (int j = 0; j < w; j++) {
                String[] z = br.readLine().split(" ");
                int s = Integer.parseInt(z[0]);
                int e = Integer.parseInt(z[1]);
                int t = Integer.parseInt(z[2]);
                graph.add(new Edge(s, e, -t));
            }

            int[] times = new int[n + 1];
            boolean flag = false;
            for (int k = 1; k < n + 1; k++) {
                for (int j = 0; j < graph.size(); j++) {
                    Edge cur = graph.get(j);
                    int time = times[cur.from] + cur.cost;
                    if (times[cur.to] > time) {
                        times[cur.to] = time;
                        if (k == n) {
                            flag = true;
                        }
                    }
                }
            }

            if (flag) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());
    }

    static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
