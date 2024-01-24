import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int end = 0;

        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            if (arr[i] > end) {
                end = arr[i];
            }
        }
        int m = Integer.parseInt(br.readLine());
        int start = m / n;
        int answer = 0;

        while (start <= end) {
            int middle = (start + end) / 2;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= middle) {
                    sum += arr[i];
                } else {
                    sum += middle;
                }
            }
            if (sum <= m) {
                answer = middle;
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        System.out.println(answer);


    }
}
