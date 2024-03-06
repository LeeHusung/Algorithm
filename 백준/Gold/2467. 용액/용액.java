import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        long[] ans = new long[2];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int start = 0;
        int end = arr.length - 1;
        long k = Long.MAX_VALUE;
        while (start < end) {
            long x = arr[start] + arr[end];
            if (Math.abs(x) < k) {
                k = Math.abs(x);
                ans[0] = arr[start];
                ans[1] = arr[end];
            }
            if (x > 0) {
                end--;
            } else {
                start++;
            }
        }

        Arrays.sort(ans);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}