import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        long start = 0;
        long end = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, arr[i]);
        }

        while (start <= end) {
            long middle = (start + end) / 2;
            if (middle == 0) break;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (arr[i] / middle);
            }
            if (sum < k) {
                end = middle - 1;
            } else start = middle + 1;
        }
        System.out.println(end);


    }
}
