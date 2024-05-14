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

        int start = 0;
        int end = 0;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
        }

        int answer = 0;
        while (start <= end) {
            int middle = (start + end) / 2;
            int sum = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                sum += arr[i];
                if (sum > middle) {
                    sum = 0;
                    cnt++;
                }
            }

            if (cnt <= k) {
                end = middle - 1;
                answer = middle;
            } else start = middle + 1;
        }
        System.out.println(answer);


    }
}
