import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int n;
    static int[][] dp;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][2];
        ch = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        D(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void D(int x) {
        dp[x][1] = 1;
        ch[x] = 1;
        for (Integer i : graph.get(x)) {
            if (ch[i] == 0) {
                D(i);
                dp[x][0] += dp[i][1];
                dp[x][1] += Math.min(dp[i][0], dp[i][1]);
            }
        }
    }
}
