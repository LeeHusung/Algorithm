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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if (n == 1) {
            System.out.println(1);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!pq.isEmpty()) {
                int p = pq.peek();
                if (arr[i][0] < p) {
                    pq.offer(arr[i][1]);
                    continue;
                } else {
                    pq.poll();
                    pq.offer(arr[i][1]);
                    continue;
                }
            }
            pq.offer(arr[i][1]);
        }

        System.out.println(pq.size());
    }
}
