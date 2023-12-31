import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int[][] dp;
    static Integer[] leftArr, rightArr;

    public static int D(int x, int y) {
        if (x == n || y == n) return 0;
        if (dp[x][y] != -1) return dp[x][y];
        dp[x][y] = 0;
        if (leftArr[x] > rightArr[y]) {
            dp[x][y] = Math.max(dp[x][y], rightArr[y] + D(x, y + 1));
        } else {
            dp[x][y] = Math.max(D(x + 1, y), D(x + 1, y + 1));
        }
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][n + 1];
        String[] left = br.readLine().split(" ");
        String[] right = br.readLine().split(" ");
        leftArr = new Integer[left.length];
        rightArr = new Integer[right.length];
        for (int i = 0; i < n; i++) {
            leftArr[i] = Integer.parseInt(left[i]);
            rightArr[i] = Integer.parseInt(right[i]);
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int answer = D(0, 0);

        System.out.println(answer);

    }
}
