import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s1 = br.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int k = Integer.parseInt(s1[2]);
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<int[]> groups = new ArrayList<>();
        parents = new int[n + 1];

        int[] person = new int[n + 1];
        Arrays.fill(person, 1);
        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            union(x, y);
        }
        for (int i = 1; i < n + 1; i++) {
            if (parents[i] != i) {
                int p = find(i);
                arr[p] += arr[i];
                person[p] += person[i];
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (parents[i] == i) {
                groups.add(new int[]{person[i], arr[i]});
            }
        }


        long[][] dp = new long[groups.size() + 1][k];
        for (int i = 1; i <= groups.size(); i++) {
            int people = groups.get(i-1)[0];
            long canGet = groups.get(i-1)[1];
            for (int j = 0; j < k; j++) {
                if (people <= j) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-people] + canGet);
                else dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(dp[groups.size()][k-1]);

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

    private static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }
}