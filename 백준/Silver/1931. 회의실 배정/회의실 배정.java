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
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            arr[i][0] = start;
            arr[i][1] = end;
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] == a[0] ? b[1] - a[1] : b[0] - a[0]);

        for (int i = 0; i < arr.length; i++) {
            if (!pq.isEmpty() && pq.peek()[1] > arr[i][1]) {
                pq.poll();
                pq.add(arr[i]);
                continue;
            }
            if (!pq.isEmpty() && pq.peek()[1] > arr[i][0]) continue;

            pq.offer(arr[i]);
        }

        System.out.println(pq.size());
    }
}
