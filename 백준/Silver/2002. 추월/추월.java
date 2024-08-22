import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] in = new String[n];
        String[] out = new String[n];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            in[i] = br.readLine();
            map.put(in[i], i);
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            out[i] = br.readLine();
            Integer p = map.get(out[i]);
            b[i] = p;
        }
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        int[] ch = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 1) continue;
            for (int j = i; j < n; j++) {
                if (a[i] > b[j]) continue;
                if (ch[b[j]] == 1) continue;
                if (a[i] != b[j]) {
                    ch[b[j]] = 1;
                }
                if (a[i] == b[j]) break;
            }
        }
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 1) cnt++;
        }
        System.out.println(cnt);
    }
}
