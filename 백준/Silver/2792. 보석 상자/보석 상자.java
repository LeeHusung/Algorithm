import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        int sum = 0;
        int answer = 0;
        int left = 1;
        int right = 0;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            right = Math.max(arr[i], right);
        }

        while (left <= right) {
            int middle = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > middle) {
                    cnt += arr[i] / middle;
                    if (arr[i] % middle != 0) cnt++;
                } else if (arr[i] <= middle) {
                    cnt += 1;
                }
            }
            if (cnt <= n) {
                answer = middle;
                right = middle - 1;

            } else {
                left = middle + 1;
            }
        }
        System.out.println(answer);

    }
}
