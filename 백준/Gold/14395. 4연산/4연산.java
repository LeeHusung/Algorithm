import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Main {

    static long s, t;

    static class Node {

        long num;
        String str;

        public Node(long num, String str) {
            this.num = num;
            this.str = str;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        s = Integer.parseInt(s1[0]);
        t = Integer.parseInt(s1[1]);
        Set<Long> set = new HashSet<>();
        if (s == t) {
            System.out.println(0);
            return;
        }

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(s, ""));
        set.add(s);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.num == t) {
                System.out.println(node.str);
                return;
            }
            if (node.num * node.num <= t && !set.contains(node.num * node.num)) {
                q.offer(new Node(node.num * node.num, node.str + "*"));
                set.add(node.num * node.num);
            }
            if (node.num + node.num <= t && !set.contains(node.num + node.num)) {
                q.offer(new Node(node.num + node.num, node.str + "+"));
                set.add(node.num + node.num);
            }
            if (node.num != 0 && node.num / node.num <= t && !set.contains(node.num / node.num)) {
                q.offer(new Node(node.num / node.num, node.str + "/"));
                set.add(node.num / node.num);
            }
        }
        System.out.println(-1);

    }
}
