import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[][] arr;
    static int[] parent;
    static int[] size;
    static int cnt;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            map.clear();
            cnt = 0;
            int idx = 1;
            int n = Integer.parseInt(br.readLine());
            arr = new String[n][2];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().split(" ");
                arr[i][0] = s[0];
                arr[i][1] = s[1];
                if (!map.containsKey(s[0])) {
                    map.put(s[0], idx++);
                }
                if (!map.containsKey(s[1])) {
                    map.put(s[1], idx++);
                }
            }

            parent = new int[idx];
            size = new int[idx];
            for (int i = 1; i < idx; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            for (int i = 0; i < n; i++) {
                String x = arr[i][0];
                String y = arr[i][1];
                int xx = map.get(x);
                int yy = map.get(y);
                sb.append(union(xx, yy)).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            parent[fy] = fx;
            size[fx] += size[fy];
        }
        return size[fx];
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
