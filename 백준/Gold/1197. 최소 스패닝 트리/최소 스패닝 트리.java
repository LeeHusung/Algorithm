import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int v = Integer.parseInt(s[0]);
        int e = Integer.parseInt(s[1]);
        parents = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            parents[i] = i;
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]);
            int y = Integer.parseInt(s1[1]);
            int cost = Integer.parseInt(s1[2]);
            list.add(new int[]{x, y, cost});
        }
        Collections.sort(list, (a, b) -> a[2] - b[2]);
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] p = list.get(i);
            if (find(p[0]) == find(p[1])) continue;
            answer += p[2];
            cnt++;
            if (cnt == v - 1) break;
            union(p[0], p[1]);
        }
        System.out.println(answer);
    }

    private static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx > fy) {
            parents[fx] = fy;
        } else {
            parents[fy] = fx;
        }
    }

    public static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return find(parents[x]);
    }
}