import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            graph.get(start).add(end);
        }

        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n + 1];
        int[] ch = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        q.offer(x);
        ch[x] = 1;
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int p = q.poll();
                if (L < dist[p]) {
                    dist[p] = L;
                }
                for (int z : graph.get(p)) {
                    if (ch[z] == 0) {
                        ch[z] = 1;
                        q.offer(z);
                    }
                }

            }
            L++;

        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == k) {
                list.add(i);
            }
        }
        Collections.sort(list);
        if (list.isEmpty()) {
            System.out.println(-1);
            return;
        }
        for (int w : list) {
            System.out.println(w);
        }
    }
}
