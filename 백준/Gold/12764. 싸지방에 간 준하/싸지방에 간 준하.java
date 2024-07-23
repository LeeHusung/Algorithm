import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int[][] arr = new int[n][2];
        int[] seat = new int[n + 1];
        int idx = 1;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            arr[i][0] = start;
            arr[i][1] = end;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];
            if (q.isEmpty()) {
                q.offer(new int[]{start, end, idx});
                seat[idx++]++;
                continue;
            }
            while (!q.isEmpty()) {
                if (q.peek()[1] <= start) {
                    int[] poll = q.poll();
                    pq.offer(poll[2]);
                } else break;
            }

            if (!pq.isEmpty()) {
                Integer p = pq.poll();
                q.offer(new int[]{start, end, p});
                seat[p]++;
            } else {
                q.offer(new int[]{start, end, idx});
                seat[idx++]++;
            }
        }
        idx--;
        StringBuilder sb = new StringBuilder();
        sb.append(idx).append("\n");
        for (int i = 1; i <= idx; i++) {
            sb.append(seat[i]).append(" ");
        }
        System.out.println(sb);
    }
}
