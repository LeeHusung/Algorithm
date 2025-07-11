import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m, k;
    static int[] parents;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        k = Integer.parseInt(split[2]);

        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int x = Integer.parseInt(st.nextToken());
            parents[x] = 0;
        }

        arr = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] split1 = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(split1[0]);
            arr[i][1] = Integer.parseInt(split1[1]);
            arr[i][2] = Integer.parseInt(split1[2]);
        }
        Arrays.sort(arr, (a, b) -> a[2] - b[2]);

        long answer = 0;
        for (int[] x : arr) {
            int fx = find(x[0]);
            int fy = find(x[1]);
            if (fx != fy) {
                union(fx, fy);
                answer += x[2];
            }
        }
        System.out.println(answer);

    }

    private static void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx < fy) {
            parents[fy] = fx;
        } else {
            parents[x] = fy;
        }
    }

    private static int find(int x) {
        if (x == parents[x]) return x;
        return parents[x] = find(parents[x]);
    }
}
