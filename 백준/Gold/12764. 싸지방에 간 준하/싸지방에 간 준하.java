import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    static class Node {
        int x; int y; int seat;

        public Node(final int x, final int y, final int seat) {
            this.x = x;
            this.y = y;
            this.seat = seat;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] seat = new int[n];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(e -> e.y));
        PriorityQueue<Integer> remains = new PriorityQueue<>();
        PriorityQueue<Node> arr = new PriorityQueue<>(Comparator.comparing(e -> e.x));
        int idx = 0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            arr.offer(new Node(start, end, 0));
        }
        while (!arr.isEmpty()) {
            Node node = arr.poll();
            if (pq.isEmpty()) {
                pq.offer(new Node(node.x, node.y, idx));
                seat[idx++]++;
                continue;
            }

            while (!pq.isEmpty()) {
                if (pq.peek().y < node.x) {
                    Node poll = pq.poll();
                    remains.add(poll.seat);
                } else break;
            }
            if (remains.isEmpty()) {
                pq.offer(new Node(node.x, node.y, idx));
                seat[idx++]++;
            } else {
                Integer seatno = remains.poll();
                pq.offer(new Node(node.x, node.y, seatno));
                seat[seatno]++;
            }
        }

        System.out.println(idx);
        for (int i = 0; i < idx; i++) {
            System.out.print(seat[i] + " ");
        }
    }
}
