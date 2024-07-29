import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        int n = Integer.parseInt(s[0]);
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
        Arrays.sort(robot);
        int[][] arr = new int[n - 1][3];
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            graph.get(arr[i][0]).add(new int[]{arr[i][1], arr[i][2]});
            graph.get(arr[i][1]).add(new int[]{arr[i][0], arr[i][2]});
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[] dist1 = new int[n + 1];
        int[] dist2 = new int[n + 1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[robot[0]] = 0;
        dist2[robot[1]] = 0;

        pq.offer(new int[]{robot[0], 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (p[1] > dist1[p[0]]) continue;
            for (int[] x : graph.get(p[0])) {
                if (dist1[x[0]] > p[1] + x[1]) {
                    dist1[x[0]] = p[1] + x[1];
                    pq.offer(new int[]{x[0], dist1[x[0]]});
                }
            }
        }
        pq.offer(new int[]{robot[1], 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (p[1] > dist2[p[0]]) continue;
            for (int[] x : graph.get(p[0])) {
                if (dist2[x[0]] > p[1] + x[1]) {
                    dist2[x[0]] = p[1] + x[1];
                    pq.offer(new int[]{x[0], dist2[x[0]]});
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i][0];
            int y = arr[i][1];
            min = Math.min(min, dist1[x] + dist2[y]);
        }
        System.out.println(min);


    }
}
