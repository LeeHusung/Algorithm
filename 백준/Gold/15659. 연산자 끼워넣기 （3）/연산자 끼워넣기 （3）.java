import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, max, min;
    static int[] cal = new int[4];
    static int[] arr;

    private static void D(int idx, int sum, int pre) {
        if (idx == n) {
            max = Math.max(max, sum + pre);
            min = Math.min(min, sum + pre);
            return;
        }

        for (int i = 0; i < cal.length; i++) {
            if (cal[i] > 0) {
                cal[i]--;
                if (i == 0) {
                    D(idx + 1, sum + pre, arr[idx]);
                } else if (i == 1) {
                    D(idx + 1, sum + pre, -arr[idx]);
                } else if (i == 2) {
                    D(idx + 1, sum, pre * arr[idx]);
                } else if (i == 3) {
                    D(idx + 1, sum, pre / arr[idx]);
                }
                cal[i]++;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(s[i]);
        }

        D(1, 0, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }
}
