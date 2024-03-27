import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] count = new int[n + 1];
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            count[y]++;
            graph.get(x).add(y);
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) {
                pq.offer(i);
            }
        }
        while (!pq.isEmpty()) {
            Integer p = pq.poll();
            sb.append(p).append(" ");
            for (int x : graph.get(p)) {
                count[x]--;
                if (count[x] == 0) {
                    pq.offer(x);
                }
            }
        }
        System.out.println(sb);
    }
}
