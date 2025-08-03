import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(v).add(new int[]{u, c});
        }
        Set<Integer> set = new HashSet<>();

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            set.add(Integer.parseInt(s1[i]));
        }

        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> Math.toIntExact(a[1] - b[1]));
        for (Integer i : set) {
            q.offer(new long[]{i, 0});
            dist[i] = 0;
        }

        while (!q.isEmpty()) {
            long[] p = q.poll();
            if (p[1] > dist[(int) p[0]]) continue;
            for (int[] x : graph.get((int) p[0])) {
//                if (set.contains(x[0])) continue;
//                if (p[1] + x[1] > dist[z]) continue;
//                if (ch[x[0]] == 1) continue;
                dist[x[0]] = Math.min(dist[x[0]], p[1] + x[1]);
//                ch[x[0]] = 1;
                q.offer(new long[]{x[0], x[1] + p[1]});
            }
        }
//            System.out.println(Arrays.toString(dist));

        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                dist[i] = 0;
            }
        }

        long max = Long.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }
        List<long[]> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (dist[i] == max) {
                list.add(new long[]{i, dist[i]});
            }
        }
        list.sort((a, b) -> Math.toIntExact(a[0] - b[0]));
        System.out.println(list.get(0)[0]);
        System.out.println(list.get(0)[1]);


    }
}
