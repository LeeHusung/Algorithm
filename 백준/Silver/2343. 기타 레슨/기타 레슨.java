
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        String[] s1 = br.readLine().split(" ");
        int sum = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
            if (arr[i] > start) start = arr[i];
            sum += arr[i];
        }

        int end = sum;
        while (start <= end) {
            int middle = (start + end) / 2;
            int k = 0;
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (k + arr[i] > middle) {
                    cnt++;
                    k = 0;
                }
                k += arr[i];
            }
            if (k != 0) {
                cnt++;
            }
            if (cnt > m) {
                start = middle + 1;

            } else end = middle - 1;

        }
        System.out.println(start);

    }
}
