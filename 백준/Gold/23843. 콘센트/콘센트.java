import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        Integer[] arr = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> b - a);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int idx = 0;
        long answer = 0;
        while (true) {
            if (pq.size() == m) {
                int small = pq.poll();
                int next = small + arr[idx];
                pq.offer(next);
                answer = next;
                idx++;
            }
            if (pq.size() != m) {
                pq.offer(arr[idx]);
                idx++;
            }
            if (idx >= n) break;
        }
       while (!pq.isEmpty()) {
            answer = pq.poll();
        }
        System.out.println(answer);

    }
}
