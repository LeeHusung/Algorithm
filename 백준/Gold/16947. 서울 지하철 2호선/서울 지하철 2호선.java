import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {

    static int n;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] isCycle;
    static StringBuilder sb = new StringBuilder();
    static Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isCycle = new int[n];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]) - 1;
            int y = Integer.parseInt(s[1]) - 1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for (int i = 0; i < n; i++) {
            if (D(i, i, i)) {
                break;
            }
            isCycle = new int[n];
        }

        for (int i = 0; i < n; i++) {
            if (isCycle[i] == 0) {
                sb.append(bfs(i) - 1).append(" ");
                q.clear();
            } else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static int bfs(final int x) {
        int[] ch = new int[n];
        ch[x] = 1;
        q.offer(x);
        int L = 0;
        while (!q.isEmpty()) {
            L++;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Integer p = q.poll();
                if (isCycle[p] == 1) {
                    return L;
                }
                for (Integer node : graph.get(p)) {
                    if (ch[node] == 0) {
                        ch[node] = 1;
                        q.offer(node);
                    }
                }
            }
        }
        return 0;
    }

    private static boolean D(int pre, int x, int original) {
        isCycle[x] = 1;
        for (Integer p : graph.get(x)) {
            if (isCycle[p] == 0) {
                if (D(x, p, original)) return true;
            } else if (pre != p && p == original) return true;
        }
        isCycle[x] = 0;
        return false;
    }

}
