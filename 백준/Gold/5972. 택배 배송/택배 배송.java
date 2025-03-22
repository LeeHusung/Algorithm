import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.offer(new int[]{1, 0});
        int[] arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = Integer.MAX_VALUE;
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n) break;
            if (cur[1] > arr[cur[0]]) continue;
            for (int[] x : graph.get(cur[0])) {
                if (arr[x[0]] > cur[1] + x[1]) {
                    arr[x[0]] = cur[1] + x[1];
                    q.offer(new int[]{x[0], x[1] + cur[1]});
                }
            }
        }

        System.out.println(arr[n]);

    }
}
