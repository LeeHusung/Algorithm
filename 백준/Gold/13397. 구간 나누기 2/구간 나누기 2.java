import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        int start = 0;
        int end = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, arr[i]);
        }
        int answer = Integer.MAX_VALUE;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (check(middle, arr, n) <= m) {
                end = middle - 1;
                answer = Math.min(answer, middle);
            } else start = middle + 1;
        }
        System.out.println(answer);
    }

    private static int check(int middle, int[] arr, int n) {
        int max = arr[0], min = arr[0];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
            if (max - min > middle) {
                cnt++;
                max = arr[i];
                min = arr[i];
            }
        }
        return cnt;
    }
}
