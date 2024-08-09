import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] b = new int[n];
        boolean re = false;
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            if (b[i] > 0) re = true;
        }
        if (!re) {
            System.out.println(0);
            return;
        }

        int cnt = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (b[i] % 2 == 1) {
                    b[i]--;
                    cnt++;
                }
            }
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (b[i] > 0) flag = true;
            }
            if (!flag) break;
            else {
                for (int i = 0; i < n; i++) {
                    b[i] /= 2;
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
