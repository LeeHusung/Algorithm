import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] count = new int[n + 1];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[k];
            for (int j = 0; j < k; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < k - 1; j++) {
                for (int l = j + 1; l < k; l++) {
                    count[arr[l]]++;
                    graph.get(arr[j]).add(arr[l]);
                }
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (!q.isEmpty()) {
            Integer p = q.poll();
            cnt++;
            sb.append(p).append("\n");
            for (int x : graph.get(p)) {
                count[x]--;
                if (count[x] == 0) {
                    q.offer(x);
                }
            }
        }
        if (cnt != n) {
            System.out.println(0);
            return;
        }
        System.out.println(sb);

    }
}
