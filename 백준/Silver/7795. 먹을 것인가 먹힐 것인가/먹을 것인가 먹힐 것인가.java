import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t --> 0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[] arr = new int[n];
            int[] brr = new int[m];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < m; i++) {
                brr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(brr);
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                int x = 0;
                int y = brr.length - 1;
                while (x <= y) {
                    int middle = (x + y) / 2;
                    if (brr[middle] < arr[i]) {
                        x = middle + 1;
                    } else {
                        y = middle - 1;
                    }
                }
                cnt += x;
            }
            sb.append(cnt).append("\n");

        }
        System.out.println(sb);
    }
}
