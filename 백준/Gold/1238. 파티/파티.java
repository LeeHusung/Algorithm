import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2]);
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int start = Integer.parseInt(s1[0]);
            int finish = Integer.parseInt(s1[1]);
            int dist = Integer.parseInt(s1[2]);
            graph.get(start).add(new int[]{finish, dist});
        }


        int[] res = new int[n + 1];
        int idx = 0;

        for (int i = 1; i <= n; i++) {
            int[] dist = new int[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            if (i == x) continue;
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{i, 0});
            while (!q.isEmpty()) {
                int[] p = q.poll();
                if (p[1] > dist[p[0]]) continue;
                for (int[] z : graph.get(p[0])) {
                    if (dist[z[0]] > z[1] + p[1]) {
                        dist[z[0]] = z[1] + p[1];
                        q.offer(new int[]{z[0], p[1] + z[1]});
                    }
                }
            }
//            for (int j = 0; j < dist.length; j++) {
//                System.out.print(dist[j] + " ");
//            }
//            System.out.println();
            res[idx++] = dist[x];
        }
//
//        System.out.println("=====res=====");
//        for (int i = 0; i < res.length; i++) {
//            System.out.print(res[i] + " ");
//        }

        int[] dist22 = new int[n + 1];
        Arrays.fill(dist22, Integer.MAX_VALUE);
        int idx22 = 0;
        int[] res2 = new int[n + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, 0});
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (p[1] > dist22[p[0]]) continue;
            for (int[] z : graph.get(p[0])) {
                if (dist22[z[0]] > z[1] + p[1]) {
                    dist22[z[0]] = z[1] + p[1];
                    q.offer(new int[]{z[0], p[1] + z[1]});
                }
            }
        }
//        System.out.println("====res2====");
//        for (int j = 0; j < res2.length; j++) {
//            System.out.print(res2[j] + " ");
//        }
//        System.out.println();
        for (int i = 0; i < dist22.length - 1; i++) {
            if (i != x - 1) {
                res2[idx22++] = dist22[i + 1];
            }
        }
//        System.out.println();

//        System.out.println("====dist22====");
//        for (int j = 0; j < dist22.length; j++) {
//            System.out.print(dist22[j] + " ");
//        }
//        System.out.println("====res====");
//        for (int j = 0; j < res.length; j++) {
//            System.out.print(res[j] + " ");
//        }
//        System.out.println();
//        System.out.println("====res2====");
//        for (int j = 0; j < res2.length; j++) {
//            System.out.print(res2[j] + " ");
//        }

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < res.length; i++) {
            if (res[i] != 0 && res2[i] != 0) {
                answer = Math.max(answer, res[i] + res2[i]);
            }
        }
        System.out.println(answer);

    }
}
