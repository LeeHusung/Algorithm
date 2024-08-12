import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static String[] gender;
    static int[][] arr;
    static int[] parents;
    static int[] ch;
    static long cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        parents = new int[n + 1];
        ch = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
        gender = new String[n + 1];
        arr = new int[m][3];
        cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            gender[i] = st.nextToken();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
            arr[i][2] = cost;
        }
        Arrays.sort(arr, (a, b) -> a[2] - b[2]);


        for (int i = 0; i < arr.length; i++) {
            int[] p = arr[i];
            int x = p[0];
            int y = p[1];
            int cost = p[2];
            if (find(x) != find(y) && !gender[x].equals(gender[y])) {
                union(x, y);
                ch[x] = 1;
                ch[y] = 1;
                cnt += cost;
            }
        }

        for (int i = 1; i < parents.length; i++) {
            if (ch[i] == 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(cnt);

    }

    private static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fy > fx) {
            parents[fy] = fx;
        } else parents[fx] = fy;
    }

    private static int find(int x) {
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
}
