
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            return Math.abs(o.x - o.y) - Math.abs(x - y);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            pq.offer(new Node(a, b));
        }

        int res = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (x - 5000 >= pq.size() * 1000 && node.x > node.y) {
                res += node.x;
                x -= 5000;
            } else {
                res += node.y;
                x -= 1000;
            }
        }
        System.out.println(res);


    }
}
