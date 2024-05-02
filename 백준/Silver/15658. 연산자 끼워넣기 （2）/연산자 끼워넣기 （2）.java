import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, min, max;
    static int[] arr, cal, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        arr = new int[n];
        cal = new int[4];
        tmp = new int[n-1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        D(0);

        System.out.println(max);
        System.out.println(min);

    }

    private static void D(int L) {
        if (L == n - 1) {
            int x = arr[0];
            for (int i = 0; i < n - 1; i++) {
                if (tmp[i] == 0) {
                    x += arr[i + 1];
                } else if (tmp[i] == 1) {
                    x -= arr[i + 1];
                } else if (tmp[i] == 2) {
                    x *= arr[i + 1];
                } else if (tmp[i] == 3) {
                    if (x < 0) {
                        x = -(-x / arr[i + 1]);
                        continue;
                    }
                    x /= arr[i + 1];
                }
            }
            max = Math.max(max, x);
            min = Math.min(min, x);
            return;
        }

        for (int i = 0; i < cal.length; i++) {
            if (cal[i] > 0) {
                tmp[L] = i;
                cal[i]--;
                D(L + 1);
                cal[i]++;
                tmp[L] = 0;
            }
        }
    }
}
