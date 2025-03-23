import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int answer = 0;
    static int[][] cnt;
    static int k, p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        p = Integer.parseInt(s[2]);
        int x = Integer.parseInt(s[3]);

        boolean[][] arr = {
            {true, true, true, false, true, true, true},
            {false, false, true, false, false, true, false},
            {true, false, true, true, true, false, true},
            {true, false, true, true, false, true, true},
            {false, true, true, true, false, true, false},
            {true, true, false, true, false, true, true},
            {true, true, false, true, true, true, true},
            {true, false, true, false, false, true, false},
            {true, true, true, true, true, true, true},
            {true, true, true, true, false, true, true}
        };

        cnt = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int z = 0;
                for (int l = 0; l < 7; l++) {
                    if (arr[i][l] != arr[j][l]) {
                        z++;
                    }
                }
                cnt[i][j] = z;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            int sum = calculate(i, x);
            if (sum == 1) answer++;
        }

        System.out.println(answer);
    }

    private static int calculate(int i, int x) {
        int sum = 0;
        for (int j = 0; j < k; j++) {
            int a = i % 10;
            int b = x % 10;
            sum += cnt[a][b];
            i /= 10;
            x /= 10;
        }
        if (sum > 0 && sum <= p) return 1;
        return 0;
    }


}
