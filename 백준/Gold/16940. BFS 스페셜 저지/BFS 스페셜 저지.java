import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        String[] check = br.readLine().split(" ");
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = Integer.parseInt(check[i]);
        }
        int idx = 1;
        if (order[0] != 1) {
            System.out.println(0);
            return;
        }

        int[] ch = new int[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        ch[1] = 1;
        while (!q.isEmpty()) {
            Integer p = q.poll();

            Set<Integer> set = new HashSet<>();
            for (Integer x : graph.get(p)) {
                if (ch[x] == 0) set.add(x);
            }
            for (int i = idx; i < idx + set.size(); i++) {
                if (!set.contains(order[i])) {
                    System.out.println(0);
                    return;
                }
            }
            for (int i = idx; i < idx + set.size(); i++) {
                ch[order[i]] = 1;
                q.offer(order[i]);
            }
            idx += set.size();
        }
        System.out.println(1);
    }
}
