import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int[] ch = new int[n + 1];
        int[] res = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        ch[1] = 1;
        while (!q.isEmpty()) {
            Integer p = q.poll();
            for (int x : graph.get(p)) {
                if (ch[x] == 0) {
                    ch[x] = 1;
                    res[x] = p;
                    q.offer(x);
                }
            }
        }
        for (int i = 2; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
}
