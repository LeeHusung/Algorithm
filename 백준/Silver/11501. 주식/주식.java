import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[n];
            String[] s = br.readLine().split(" ");
            int idx = n - 1;
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(s[idx--]);
            }

            long answer = 0;

            long x = arr[0];
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] < x) {
                    answer += x - arr[j];
                } else {
                    x = arr[j];
                }
            }


            System.out.println(answer);
        }

    }
}
