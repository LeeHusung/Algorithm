import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }
        int cnt = 0;
        for (int i = 1; i <= P; i++) {
            int x = Integer.parseInt(br.readLine());
            int fx = find(x);
            if (fx == 0) break;
            union(fx, fx-1);
            cnt++;
        }

        System.out.println(cnt);
    }

    private static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx > fy) parent[fx] = fy;
        else parent[fy] = fx;
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}