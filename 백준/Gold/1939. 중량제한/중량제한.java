import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, startNode, endNode, res, start, end;
    static int[] ch;
    static boolean flag = false;
    static ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        ch = new int[n + 1];
        m = Integer.parseInt(st.nextToken());
        res = 0;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        start = 1;
        end = 1;
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);
            end = Math.max(end, cost);
            graph.get(x).add(new int[]{y, cost});
            graph.get(y).add(new int[]{x, cost});
        }

        String[] s = br.readLine().split(" ");
        startNode = Integer.parseInt(s[0]);
        endNode = Integer.parseInt(s[1]);

        while (start <= end) {
            int middle = (start + end) / 2; //중량값
//            System.out.println(middle);
            if (!D(startNode, middle)) {
                end = middle - 1;
            } else {
                start = middle + 1;
                res = middle;
            }
        }
        System.out.println(res);
    }

    private static boolean D(int point, int middle) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n + 1; i++) {
            ch[i] = 0;
        }
        q.offer(point);
        ch[point] = 1;
        while (!q.isEmpty()) {
            int p = q.poll();
            if (p == endNode) return true;
            for (int[] x : graph.get(p)) {
                if (x[1] < middle) continue;
                if (ch[x[0]] == 0) {
                    ch[x[0]] = 1;
                    q.offer(x[0]);
                }
            }
        }
        return false;
    }
}
