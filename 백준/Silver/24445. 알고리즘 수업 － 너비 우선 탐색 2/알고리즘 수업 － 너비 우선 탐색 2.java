
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int r = Integer.parseInt(s[2]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(r);
        int[] ch = new int[n + 1];
        int[] res = new int[n + 1];
        ch[r] = 1;
        int L = 2;
        res[r] = 1;
        while (!q.isEmpty()) {
            Integer p = q.poll();
            Collections.sort(graph.get(p), Collections.reverseOrder());
            for (int x : graph.get(p)) {
                if (ch[x] == 0) {
                    res[x] = L++;
                    ch[x] = 1;
                    q.offer(x);
                }
            }
        }
        for (int i = 1; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
}
