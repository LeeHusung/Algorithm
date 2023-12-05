
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) pq.offer(x);
            if (x == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(pq.poll());
            }


        }

    }
}
