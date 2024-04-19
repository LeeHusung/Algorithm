import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int length = s.length;
        int[] arr = new int[length];
        for (int i = 1; i < length + 1; i++) {
            int x = Integer.parseInt(s[i-1]);
            if (x == 0) break;
            arr[i] = x;
        }
     
        int[][][] dp = new int[length][5][5]; //총횟수, 왼발, 오른발
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][j][k] = 1000000;
                }
            }
        }
        dp[0][0][0] = 0;
        for (int i = 1; i < length; i++) {
            int next = arr[i];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    dp[i][next][k] = Math.min(dp[i][next][k], dp[i - 1][j][k] + use(j, next));
                    dp[i][j][next] = Math.min(dp[i][j][next], dp[i - 1][j][k] + use(k, next));
                }
            }
        }

        int answer = 1000000;
        int next = arr[length - 1];
        for (int i = 0; i < 5; i++) {
            answer = Math.min(answer, dp[length - 1][i][next]);
            answer = Math.min(answer, dp[length - 1][next][i]);
        }
        System.out.println(answer);

    }

    private static int use(int j, int next) {
        if (j == 0) return 2;
        if (j == next) return 1;
        else if (Math.abs(j - next) == 2) return 4;
        else return 3;
    }
}
