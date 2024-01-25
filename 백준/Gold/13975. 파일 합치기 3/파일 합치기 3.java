import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < k; j++) {
                pq.offer(Long.parseLong(s[j]));
            }
            long sum = 0;
            while (pq.size() != 1) {
                long p1 = pq.poll();
                long p2 = pq.poll();
                sum += p1 + p2;
                pq.offer(p1 + p2);
            }
            sb.append(sum).append("\n");

        }

        System.out.println(sb);

    }
}
