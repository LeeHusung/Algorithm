import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int l = Integer.parseInt(s[2]);
        int start = 1;
        int end = l;
        int[] arr = new int[n + 2];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }
        arr[n + 1] = l;
        Arrays.sort(arr);
        int res = 0;

        while (start <= end) {
            int middle = (start + end) / 2;
            int cnt = 0;
            for (int i = 1; i <= n + 1; i++) {
                int x = arr[i] - arr[i - 1] - 1;
                cnt += x / middle;
            }

            if (cnt <= m) {
                end = middle - 1;
            }
            if (cnt > m) {
                start = middle + 1;
            }
        }
        System.out.println(start);



    }
}
