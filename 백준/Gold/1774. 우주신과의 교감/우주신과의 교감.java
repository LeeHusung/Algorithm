import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int n, m;
    static long[][] arr;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new long[n][2];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s1[0]);
            arr[i][1] = Integer.parseInt(s1[1]);
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            union(x, y);
        }

        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double xpow = Math.pow(arr[i][0] - arr[j][0], 2);
                double ypow = Math.pow(arr[i][1] - arr[j][1], 2);
                double distance = Math.sqrt(xpow + ypow);
                list.add(new Node(i + 1, j + 1, distance));
            }
        }
        Collections.sort(list);

        double answer = 0;

        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
//            System.out.println(node.x + " " + node.y + " " + node.distance);
            int x = node.x;
            int y = node.y;
            int fx = find(x);
            int fy = find(y);
            if (fx != fy) {
                answer += node.distance;
                union(fx, fy);
            }
        }

        System.out.printf("%.2f%n", answer);

    }

    private static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx < fy) {
            parent[fy] = fx;
        } else parent[fx] = fy;
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }


    static class Node implements Comparable<Node> {
        int x;
        int y;
        double distance;

        public Node(final int x, final int y, final double distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(final Node o) {
            return Double.compare(this.distance, o.distance);
        }
    }
}
