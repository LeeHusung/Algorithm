import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] split = s.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        String s1 = br.readLine();
        String[] ssplit = s1.split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(ssplit[i]);
        }

        if (m == 0) {
            int sum = 0;
            for (int x : arr) {
                sum += x;
            }
            System.out.println(sum);
            return;
        }

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (long x : arr) {
            pq.offer(x);
        }
        long answer = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            cnt++;
            long p = pq.poll();
            long p2 = pq.poll();
            long sum = p + p2;
            pq.offer(sum);
            pq.offer(sum);
            if (cnt == m) break;
        }
        for (long x : pq) {
            answer += x;
        }
        System.out.println(answer);
    }
}
