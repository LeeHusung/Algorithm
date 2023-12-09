import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, s, answer;
    static int[] arr;

    public static void D(int idx, int length, int sum) {
        if (idx == n) {
            if (length > 0 && sum == s) answer++;
            return;
        }
        D(idx + 1, length + 1, sum + arr[idx]);
        D(idx + 1, length, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] z = br.readLine().split(" ");
        n = Integer.parseInt(z[0]);
        s = Integer.parseInt(z[1]);
        answer = 0;
        arr = new int[n];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        D(0, 0, 0);
        System.out.println(answer);
    }
}
