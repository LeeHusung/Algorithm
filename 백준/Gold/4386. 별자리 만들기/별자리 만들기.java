import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    static int n;
    static int[] parent;
    static double[][] arr;
    static List<Point> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        arr = new double[n + 1][2];
        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Double.parseDouble(s[0]);
            arr[i][1] = Double.parseDouble(s[1]);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                double dist = Math.sqrt(Math.pow(arr[j][0] - arr[i][0], 2) + Math.pow(arr[j][1] - arr[i][1], 2));
                list.add(new Point(i, j, dist));
            }
        }
        Collections.sort(list);

        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int fx = find(list.get(i).x);
            int fy = find(list.get(i).y);
            if (fx != fy) {
                union(list.get(i).x, list.get(i).y);
                sum += list.get(i).dist;
            }
        }
        String res = String.format("%.2f", sum);
        System.out.print(res);
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx > fy) parent[fx] = fy;
        else parent[fy] = fx;
    }

    public static class Point implements Comparable<Point> {
        int x;
        int y;
        double dist;

        public Point(int x, int y, double dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point o) {
            return (int) (this.dist - o.dist);
        }
    }

}
