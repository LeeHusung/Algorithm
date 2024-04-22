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

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int start = 1;
        int end = arr[arr.length - 1];
        int res = 0;
        while (start <= end) {
            int middle = (start + end) / 2;
            int cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= middle) {
                    cnt += arr[i] / middle;
                }
            }
            if (cnt < n) {
                end = middle - 1;
            } else {
                start = middle + 1;
                res = middle;
            }
        }
        if (res == 0) {
            System.out.println(0);
        }else System.out.println(res);

    }
}
