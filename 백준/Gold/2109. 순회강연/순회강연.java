import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] == a[0] ? b[1] - a[1] : b[0] - a[0]);
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
            pq.offer(arr[i]);
        }

        boolean[] ch = new boolean[10002];
        int day = 1;
        int sum = 0;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            for (int i = p[1]; i >= 1; i--) {
                if (!ch[i]) {
                    ch[i] = true;
                    sum += p[0];
                    break;
                }
            }

        }
        System.out.println(sum);
    }
}
