import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        int n = Integer.parseInt(s[0]);
        int[] ch = new int[n + 1];
        int r1 = Integer.parseInt(s[1]);
        int r2 = Integer.parseInt(s[2]);
        if (n == 1) {
            System.out.println(0);
            return;
        }
        if (r1 == r2) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] robot = new int[2];
        robot[0] = r1;
        robot[1] = r2;
        int[][] arr = new int[n - 1][3];
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            graph.get(arr[i][0]).add(new int[]{arr[i][1], arr[i][2]});
            graph.get(arr[i][1]).add(new int[]{arr[i][0], arr[i][2]});
        }

        Queue<int[]> pq = new ArrayDeque<>();

        pq.offer(new int[]{robot[0], 0, 0});
        ch[robot[0]] = 1;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (p[0] == robot[1]) {
                System.out.println(p[1] - p[2]);
                return;
            }
            for (int[] x : graph.get(p[0])) {
                if (ch[x[0]] == 0) {
                    ch[x[0]] = 1;
                    pq.offer(new int[]{x[0], x[1] + p[1], Math.max(p[2], x[1])});
                }
            }
        }

    }
}
