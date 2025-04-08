import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int v, e;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        v = Integer.parseInt(s[0]);
        e = Integer.parseInt(s[1]);
        parents = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            parents[i] = i;
        }

        int[][] arr = new int[e][3];
        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            arr[i][2] = c;
        }
        Arrays.sort(arr, (a, b) -> a[2] - b[2]);

        long sum = 0;
        for (int[] x : arr) {
            int a = x[0];
            int b = x[1];
            if (find(a) != find(b)) {
                sum += x[2];
                union(a, b);
            }
        }
        System.out.println(sum);
    }

    private static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx > fy) {
            parents[fx] = fy;
        } else parents[fy] = fx;
    }

  private static int find(int x) {
    if (x != parents[x]) {
        parents[x] = find(parents[x]);  // 경로 압축
    }
    return parents[x];
}

}
