import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int idx = 0;
        int start = 0;
        int odd = 0;
        while (idx < n) {
            if (odd < k) {
                if (arr[idx] % 2 == 1) odd++;
                idx++;
                max = Math.max(max, idx - start - odd);
            } else {
                if (arr[idx] % 2 == 0) {
                    idx++;
                    max = Math.max(max, idx - start - odd);
                } else {
                    if (arr[start] % 2 == 1) {
                        odd--;
                    }
                    start++;
                }
            }
        }
        System.out.println(max);
    }
}
