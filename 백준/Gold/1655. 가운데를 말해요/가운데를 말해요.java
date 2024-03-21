import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (left.size() == right.size()) {
                left.offer(x);
            } else {
                right.offer(x);
            }

            if (!left.isEmpty() && !right.isEmpty() && left.peek() > right.peek()) {
                int l = left.poll();
                int r = right.poll();
                left.add(r);
                right.add(l);
            }

            sb.append(left.peek()).append("\n");
        }

        System.out.println(sb);

    }
}
