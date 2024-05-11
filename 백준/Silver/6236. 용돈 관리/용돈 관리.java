import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int start = 1;
        int end = 0;
        int answer = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            start = Math.max(start, arr[i]);
            end += arr[i];
        }

        while (start <= end) {
            int middle = (start + end) / 2;
            int sum = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum > middle) {
                    sum = arr[i];
                    cnt++;
                }
            }

            if (cnt > m) {
                start = middle + 1;
            } else end = middle - 1;
        }
        System.out.println(start);

    }
}
