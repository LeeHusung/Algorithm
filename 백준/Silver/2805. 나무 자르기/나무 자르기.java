import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        long[] arr = new long[n];
        long start = 0;
        long end = 0;
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(s1[i]);
            if (end < arr[i]) {
                end = arr[i];
            }
        }
        long answer = 0;

        while (start <= end) {
            long middle = (start + end) / 2;
            long sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > middle) {
                    sum += arr[i] - middle;
                }
            }
            if (sum >= m) {
                answer = middle;
                start = middle + 1;
            } else if (sum < m) {
                end = middle - 1;
            }
        }
        System.out.println(answer);


    }
}
