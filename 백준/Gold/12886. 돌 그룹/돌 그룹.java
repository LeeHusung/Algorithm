import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int x; int y; int z;

        public Node(final int x, final int y, final int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return x == node.x && y == node.y && z == node.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x, y, z));
        Set<Node> set = new HashSet<>();
        while (!q.isEmpty()) {
            Node p = q.poll();
            int one = p.x;
            int two = p.y;
            int three = p.z;
//            System.out.println(one + " " + two + " " + three);
            if (one == two && two == three) {
                System.out.println(1);
                return;
            }
            if (one > two && !set.contains(new Node(one - two, two + two, three))) {
                q.offer(new Node(one - two, two + two, three));
                set.add(new Node(one - two, two + two, three));
            }
            if (one < two && !set.contains(new Node(one + one, two - one, three))) {
                q.offer(new Node(one + one, two - one, three));
                set.add(new Node(one + one, two - one, three));
            }

            if (one < three && !set.contains(new Node(one + one, two, three - one))) {
                q.offer(new Node(one + one, two, three - one));
                set.add(new Node(one + one, two, three - one));
            }
            if (one > three && !set.contains(new Node(one - three, two, three + three))) {
                q.offer(new Node(one - three, two, three + three));
                set.add(new Node(one - three, two, three + three));
            }
            if (two > three && !set.contains(new Node(one, two - three, three + three))) {
                q.offer(new Node(one, two - three, three + three));
                set.add(new Node(one, two - three, three + three));
            }
            if (two < three && !set.contains(new Node(one, two + two, three - two))) {
                q.offer(new Node(one, two + two, three - two));
                set.add(new Node(one, two + two, three - two));
            }
        }
        System.out.println(0);
    }
}
