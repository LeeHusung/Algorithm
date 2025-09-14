import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            String[] s = br.readLine().split(" ");
            int k = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int p = Integer.parseInt(s[2]);
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for (int i = 0; i <= m; i++) {
                graph.add(new ArrayList<>());
            }

            int[] arr = new int[m + 1];

            for (int i = 0; i < p; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                arr[b]++;
            }

            Queue<int[]> q = new ArrayDeque<>();
            for (int i = 1; i <= m; i++) {
                if (arr[i] == 0) {
                    q.offer(new int[]{i, 1});
                }
            }
            int max = 0;
            int maxCnt = 1;
            while (!q.isEmpty()) {
                int[] poll = q.poll();
//                System.out.println(poll[0] + " " + poll[1]);
                if (poll[0] == m) {
                    sb.append(k).append(" ").append(poll[1]).append("\n");
                    break;
                }
                if (poll[1] == max) maxCnt++;
                max = Math.max(max, poll[1]);
//                System.out.println("max: " + max);
//                System.out.println("maxCnt: " + maxCnt);
                int tmpMax = max;
                int tmpMaxCnt = maxCnt;
                for (Integer x : graph.get(poll[0])) {
                    arr[x]--;
                    if (arr[x] == 0) {
                        if (tmpMaxCnt >= 2) q.offer(new int[]{x, tmpMax + 1});
                        else q.offer(new int[]{x, tmpMax});
                        max = 0;
                        maxCnt = 1;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
