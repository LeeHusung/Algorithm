import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int n, max;
    static int[] s; //내구도
    static int[] w; //무게
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br. readLine());
        s = new int[n];
        w = new int[n];
        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            s[i] = Integer.parseInt(s1[0]);
            w[i] = Integer.parseInt(s1[1]);
        }
        max = Integer.MIN_VALUE;

        D(0, 0);
        System.out.println(max);

    }

    private static void D(int idx, int cnt) {
        if (idx == n) {
            max = Math.max(max, cnt);
            return;
        }
        if (s[idx] < 1 || cnt == n - 1) {
            D(idx + 1, cnt);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (idx == i) continue;
            if (s[i] < 1) continue;
            s[i] -= w[idx];
            s[idx] -= w[i];
            int newCnt = cnt;
            if (s[i] < 1) cnt++;
            if (s[idx] < 1) cnt++;
            D(idx + 1, cnt);
            cnt = newCnt;
            s[i] += w[idx];
            s[idx] += w[i];
        }
    }
}