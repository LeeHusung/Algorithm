import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] people, ch;
    static int[][] dp;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        people = new int[n + 1];
        ch = new int[n + 1];
        dp = new int[n + 1][2];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            people[i + 1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] s = br.readLine().split(" ");
            graph.get(Integer.parseInt(s[0])).add(Integer.parseInt(s[1]));
            graph.get(Integer.parseInt(s[1])).add(Integer.parseInt(s[0]));
        }

        D(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));

    }

    private static void D(int x) {
        ch[x] = 1;
        dp[x][1] = people[x];
        for (Integer i : graph.get(x)) {
            if (ch[i] == 0) {
                D(i);
                dp[x][0] += Math.max(dp[i][0], dp[i][1]);
                dp[x][1] += dp[i][0];
            }
        }
    }

}
