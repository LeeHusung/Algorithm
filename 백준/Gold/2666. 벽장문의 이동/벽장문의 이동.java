import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, answer, len;
    static int[] arr;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        len = Integer.parseInt(br.readLine());
        arr = new int[len + 1];
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        D(0, x, y, 0);
        System.out.println(answer);
    }

    private static void D(int idx, int x, int y, int sum) {
        if (idx == len) {
            answer = Math.min(answer, sum);
            return;
        }
        if (x == arr[idx] || y == arr[idx]) {
            D(idx + 1, x, y, sum);
        } else if (x < arr[idx] && arr[idx] < y) {
            D(idx + 1, arr[idx], y, sum + arr[idx] - x);
            D(idx + 1, x, arr[idx], sum + y - arr[idx]);
        } else if (arr[idx] < x) {
            D(idx + 1, arr[idx], y, sum + x - arr[idx]);
        } else {
            D(idx + 1, x, arr[idx], sum + arr[idx] - y);
        }
    }
}
