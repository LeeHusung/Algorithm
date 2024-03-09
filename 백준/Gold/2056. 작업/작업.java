import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> reverse = new ArrayList<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            reverse.add(new ArrayList<>());
        }
        int[] time = new int[n + 1];
        int[] result = new int[n + 1];
        parent = new int[n + 1];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            parent[i] = cnt;
            result[i] = time[i];
            for (int j = 0; j < cnt; j++) {
                int one = Integer.parseInt(st.nextToken());
                reverse.get(one).add(i);
            }
        }

        int answer = 0;
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (parent[i] == 0) {
                q.offer(new int[]{i, time[i]});
            }
        }

        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int x : reverse.get(p[0])) {
                result[x] = Math.max(result[x], result[p[0]] + time[x]);
                parent[x]--;
                if (parent[x] == 0) {
                    q.offer(new int[]{x, result[x]});
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, result[i]);
        }
        System.out.println(answer);
    }
}