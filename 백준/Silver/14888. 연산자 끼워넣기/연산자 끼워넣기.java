import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, max, min;
    static int[] arr, ch, calculate, res;

    public static void D(int x, int L) {
        if (L == n) {
            max = Math.max(max, x);
            min = Math.min(min, x);
            return;
        } else {
            for (int j = 0; j < calculate.length; j++) {
                if (calculate[j] > 0) {
                    calculate[j]--;
                    switch (j) {
                        case 0:
                            D(x + arr[L], L + 1);
                            break;
                        case 1:
                            D(x - arr[L], L + 1);
                            break;

                        case 2:
                            D(x * arr[L], L + 1);
                            break;

                        case 3:
                            D(x / arr[L], L + 1);
                            break;

                    }
                    calculate[j]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        ch = new int[n];
        res = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        String[] cal = br.readLine().split(" ");
        calculate = new int[4];
        for (int i = 0; i < cal.length; i++) {
            calculate[i] = Integer.parseInt(cal[i]);
        }

        D(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }
}
