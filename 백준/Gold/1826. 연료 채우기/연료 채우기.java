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
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        String[] s = br.readLine().split(" ");
        int town = Integer.parseInt(s[0]);
        int fuel = Integer.parseInt(s[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int cnt = 0;
        int idx = 0;

        while (fuel < town) {
            while (idx < n && arr[idx][0] <= fuel) {
                pq.offer(arr[idx][1]);
                idx++;
            }
            if (pq.isEmpty()) {
                System.out.println(-1);
                return;
            }

            fuel += pq.poll();
            cnt++;
        }
        System.out.println(cnt);

    }

}
