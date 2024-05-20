import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            if (n == 0 && m == 0) break;
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
            int[][] arr = new int[m][3];
            int sum = 0;
            for (int i = 0; i < m; i++) {
                String[] s1 = br.readLine().split(" ");
                int x = Integer.parseInt(s1[0]) + 1;
                int y = Integer.parseInt(s1[1]) + 1;
                int z = Integer.parseInt(s1[2]);
                arr[i][0] = x;
                arr[i][1] = y;
                arr[i][2] = z;
                sum += z;
            }
            Arrays.sort(arr, (a, b) -> a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]);

            int answer = 0;
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                int x = find(arr[i][0]);
                int y = find(arr[i][1]);
                if (x == y) continue;
                union(x, y);
                cnt++;
                answer += arr[i][2];
                if (cnt == n) break;
            }
            sb.append(sum - answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);

        if (fx > fy) {
            parent[fx] = fy;
        } else parent[fy] = fx;
    }

    private static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
