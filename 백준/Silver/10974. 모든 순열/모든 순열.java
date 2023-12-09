import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] arr, res, ch;
    static StringBuilder sb = new StringBuilder();
    public static void D(int L) {
        if (L == n) {
            for (int x : res) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    res[L] = arr[i];
                    D(L + 1);
                    ch[i] = 0;
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
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        D(0);
        System.out.println(sb);
    }
}
