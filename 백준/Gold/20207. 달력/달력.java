import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        int idx = 0;

        while (idx < n) {
            int start = arr[idx][0];
            int end = arr[idx][1];
            for (int i = idx; i < n; i++) {
                if (!pq.isEmpty() && arr[i][0] > pq.peek()) {
                    pq.poll();
                }
                pq.offer(arr[i][1]);
                if (arr[i][0] <= end + 1) {
                    end = Math.max(end, arr[i][1]);
                } else {
                    break;
                }
            }
            answer += (end - start + 1) * pq.size();
            while (idx < n && arr[idx][0] <= end) {
                idx++;
            }
            pq.clear();
        }
        System.out.println(answer);
    }
}
