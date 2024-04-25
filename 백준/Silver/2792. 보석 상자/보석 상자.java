import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[m];
        int start = 1;
        int end = 0;
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            end = Math.max(end, arr[i]);
        }
        int res = Integer.MAX_VALUE;

        while (start <= end) {
            int middle = (start + end) / 2;
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > middle) {
                    cnt += arr[i] / middle;
                    if (arr[i] % middle != 0) cnt++;
                } else cnt++;
            }
            if (cnt > n) {
                start = middle + 1;
            } else {
                end = middle - 1;
                res = middle;
            }
        }
        System.out.println(res);


    }
}
