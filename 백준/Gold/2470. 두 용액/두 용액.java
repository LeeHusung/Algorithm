import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
        Arrays.sort(arr);

        int resX = 0;
        int resY = 0;
        int x = 0;
        int y = n - 1;
        long res = Long.MAX_VALUE;
        while (x < y) {
            long sum = (arr[x] + arr[y]);

            if (Math.abs(sum) < res) {
                res = Math.abs(sum);
                resX = arr[x];
                resY = arr[y];
            }
            if (sum < 0) {
                x++;
            } else {
                y--;
            }
        }
        System.out.println(resX + " " + resY);
    }
}
