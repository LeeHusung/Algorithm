import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0){
            String[] s1 = br.readLine().split(" ");
            int n = Integer.parseInt(s1[0]);
            int k = Integer.parseInt(s1[1]);
            int[] arr = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            int[] parents = new int[n + 1];
            int[] cost = new int[n + 1];
            for (int i = 0; i < k; i++) {
                String[] s = br.readLine().split(" ");
                int x = Integer.parseInt(s[0]);
                int y = Integer.parseInt(s[1]);
                graph.get(x).add(y);
                parents[y]++;
            }
            Queue<Integer> q = new ArrayDeque<>();
            for (int i = 1; i < parents.length; i++) {
                if (parents[i] == 0) {
                    q.offer(i);
                    cost[i] = arr[i];
                }
            }
            while (!q.isEmpty()) {
                int p = q.poll();
                for (int x : graph.get(p)) {
                    cost[x] = Math.max(cost[x], cost[p] + arr[x]);
                    parents[x]--;
                    if (parents[x] == 0) {
                        q.offer(x);
                    }
                }
            }

            int goal = Integer.parseInt(br.readLine());
            sb.append(cost[goal]).append("\n");
        }
        System.out.println(sb);
    }
}
