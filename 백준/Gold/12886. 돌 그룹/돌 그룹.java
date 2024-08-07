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
        int[][] ch = new int[1501][1501];
    
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(x, y, z));
        ch[x][y] = 1;
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
            if (one > two && ch[one][two] == 0) {
                ch[one][two] = 1;
                q.offer(new Node(one - two, two + two, three));
            }
            if (one < two && ch[one][two] == 0) {
                ch[one][two] = 1;
                q.offer(new Node(one + one, two - one, three));
            }

            if (one < three && ch[one][three] == 0) {
                ch[one][three] = 1;
                q.offer(new Node(one + one, two, three - one));
            }
            if (one > three && ch[one][three] == 0) {
                ch[one][three] = 1;
                q.offer(new Node(one - three, two, three + three));
            }
            if (two > three && ch[two][three] == 0) {
                ch[two][three] = 1;
                q.offer(new Node(one, two - three, three + three));
            }
            if (two < three && ch[two][three] == 0) {
                ch[two][three] = 1;
                q.offer(new Node(one, two + two, three - two));
            }
        }
        System.out.println(0);
    }
}
