import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if (n == 2) {
            System.out.println(0);
            return;
        }

        int start = 0;
        int end = arr.length - 1;
        int max = (n - 2) * Math.min(arr[start], arr[end]);

        while (start < end) {
            if (arr[start] < arr[end]) {
                start++;
            } else end--;
            max = Math.max(max, (end - start - 1) * Math.min(arr[start], arr[end]));
        }
        System.out.println(max);
    }
}
