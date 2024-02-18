import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
            sum += arr[i][1];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        long k = 0;
        long answer = 0;
        for (int i = 0; i < arr.length; i++) {
            k += arr[i][1];
            if (k >= (sum + 1) / 2) {
                answer = arr[i][0];
                break;
            }
        }
        System.out.println(answer);
    }
}
