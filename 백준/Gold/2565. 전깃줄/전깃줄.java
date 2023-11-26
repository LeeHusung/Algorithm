import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());

        int[][] arr = new int[line][2];
        for (int i = 0; i < line; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            arr[i][0] = a;
            arr[i][1] = b;
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int answer = 0;
        int[] dp = new int[line + 1];

        for (int i = 0; i < line; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i][1] > arr[j][1]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int x : dp) {
            max = Math.max(max, x);
        }

        System.out.println(line - max);

    }
}
