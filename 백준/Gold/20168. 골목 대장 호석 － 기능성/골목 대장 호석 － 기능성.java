import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n, m, a, b, c, min;
    static int[] ch;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    static LinkedList<Integer> costs = new LinkedList<>();

    private static void D(int start, int cost) {
        if (start == b) {
            Collections.sort(costs);
            min = Math.min(min, costs.get(costs.size() - 1));
            costs.clear();
            return;
        }
        for (int[] p : graph.get(start)) {
            if (ch[p[0]] == 0 && p[1] <= cost) {
                ch[p[0]] = 1;
                costs.add(p[1]);

                D(p[0], cost -= p[1]);
                costs.pollLast();
                cost += p[1];
                ch[p[0]] = 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        a = Integer.parseInt(s[2]);
        b = Integer.parseInt(s[3]);
        c = Integer.parseInt(s[4]);
        ch = new int[n + 1];
        min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(x).add(new int[]{y, cost});
            graph.get(y).add(new int[]{x, cost});
        }

        ch[a] = 1;
        D(a, c);
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else System.out.println(min);
    }

}
