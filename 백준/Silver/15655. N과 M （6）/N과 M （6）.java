import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] res, arr ,ch;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    public static void D(int L, int start) {
        if (L == m) {
            for (int x : res) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        } else {
            for (int i = start; i < arr.length; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    res[L] = arr[i];
                    D(L + 1, i + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        arr = new int[n];
        ch = new int[n];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        Arrays.sort(arr);
        res = new int[m];

        D(0, 0);
        System.out.println(sb);
    }
}
