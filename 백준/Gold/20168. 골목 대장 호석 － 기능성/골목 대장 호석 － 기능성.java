import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, a, b, c, min, start, end;
    static int[] ch;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static LinkedList<Integer> costs = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        a = Integer.parseInt(s[2]);
        b = Integer.parseInt(s[3]);
        c = Integer.parseInt(s[4]);
        start = 0;
        end = 0;
        min = -1;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            end = Math.max(end, cost);
            graph.get(x).add(new int[]{y, cost});
            graph.get(y).add(new int[]{x, cost});
        }

        while (start <= end) {
            int middle = (start + end) / 2;
            if (bfs(middle)) {
                min = middle;
                end = middle - 1;
            } else start = middle + 1;
        }
        System.out.println(min);
    }

    private static boolean bfs(int middle) {
        Queue<int[]> q = new ArrayDeque<>();
        ch = new int[n + 1];
        q.offer(new int[]{a, 0});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (p[0] == b) {
                return true;
            }
            for (int[] x : graph.get(p[0])) {
                if (ch[x[0]] == 0 && x[1] <= middle && p[1] + x[1] <= c) {
                    ch[x[0]] = 1;
                    q.offer(new int[]{x[0], p[1] + x[1]});
                }
            }
        }
        return false;
    }

}
