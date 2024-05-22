import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int cnt;
    static int[] arr, ch, isFinished;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            ch = new int[n + 1];
            isFinished = new int[n + 1];
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                D(i);
            }

            System.out.println(n - cnt);
        }
    }

    private static void D(int x) {
        ch[x] = 1;
        int next = arr[x];
        if (ch[next] == 0) {
            D(next);
        } else {
            if (isFinished[next] == 0) {
                cnt++;
                while (next != x) {
                    cnt++;
                    next = arr[next];
                }
            }
        }
        isFinished[x] = 1;
    }

}
