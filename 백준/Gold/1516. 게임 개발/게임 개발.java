import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] cost = new int[n + 1];
        int[] answer = new int[n + 1];
        int[] degree = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(st.nextToken());
            cost[i] = c;
            while (true) {
                int k = Integer.parseInt(st.nextToken());
                if (k == -1) break;
                graph.get(k).add(i);
                degree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 0) {
                q.offer(i);
                answer[i] = cost[i];
            }
        }

        while (!q.isEmpty()) {
            Integer p = q.poll();
            for (int x : graph.get(p)) {
                answer[x] = Math.max(answer[x], answer[p] + cost[x]);
                degree[x]--;
                if (degree[x] == 0) {
                    q.offer(x);
                }
            }
        }

        for (int i = 1; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }
}
