import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");
            if (split.length == 1) {
                if (pq.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                else {
                    Integer p = pq.poll();
                    System.out.println(p);
                    continue;
                }
            }
            else {
                for (int j = 1; j < Integer.parseInt(split[0]) + 1; j++) {
                    pq.offer(Integer.parseInt(split[j]));
                }
            }
        }

    }
}
