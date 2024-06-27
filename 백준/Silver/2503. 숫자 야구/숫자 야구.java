import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int answer = 0;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int q = Integer.parseInt(s[0]);
            int strike = Integer.parseInt(s[1]);
            int ball = Integer.parseInt(s[2]);
            arr[i][0] = q;
            arr[i][1] = strike;
            arr[i][2] = ball;
        }

        for (int i = 111; i <= 999; i++) {
            String x = String.valueOf(i);
            if (x.charAt(0) == '0' || x.charAt(1) == '0' || x.charAt(2) == '0') continue;
            if (x.charAt(0) == x.charAt(1) || x.charAt(0) == x.charAt(2) || x.charAt(1) == x.charAt(2)) continue;
            check(i);
        }
        System.out.println(answer);
    }

    private static void check(int num) {
        for (int[] x : arr) {
            int st = 0;
            int ball = 0;
            int k = x[0];
            if (k / 100 == num / 100) st++;
            if (k % 10 == num % 10) st++;
            if (k % 100 / 10 == num % 100 / 10) st++;
            String sb = String.valueOf(num);
            String sb2 = String.valueOf(k);
            for (int i = 0; i < sb.length(); i++) {
                for (int j = 0; j < sb2.length(); j++) {
                    if (i == j) continue;
                    if (sb.charAt(i) == sb2.charAt(j)) ball++;
                }
            }
            if (st != x[1] || ball != x[2]) return;
        }
        answer++;

    }
}
