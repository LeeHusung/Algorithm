import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, x;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        x = Integer.parseInt(s[2]);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            reverseGraph.get(b).add(a);
        }

        int[] ch = new int[n + 1];
        int[] ch2 = new int[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
//        ch[x] = 1;

        while (!q.isEmpty()) {
            int p = q.poll();
            for (Integer x : graph.get(p)) {
                if (ch[x] == 0) {
                    ch[x] = 1;
                    q.offer(x);
                }
            }
        }
//        for (int x : ch) {
//            System.out.print(x + " ");
//        }
//
//        System.out.println();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (ch[i] == 1) cnt++;
        }
        int min = n - cnt;

        q.offer(x);
        while (!q.isEmpty()) {
            int p = q.poll();
            for (Integer x : reverseGraph.get(p)) {
                if (ch2[x] == 0) {
                    ch2[x] = 1;
                    q.offer(x);
                }
            }
        }

        cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (ch2[i] == 1) cnt++;
        }



        System.out.println((cnt + 1) + " " + min);


    }
}
