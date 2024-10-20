import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[][] arr = new long[(int)n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> Math.toIntExact(a[1] == b[1] ? b[0] - a[0] : b[1] - a[1]));

        long tmp = arr[0][1];
        for (int i = 0; i < n; i++) {
            long[] cur = arr[i];
            if (cur[1] < tmp) {
                tmp = cur[1];
            }
            tmp -= cur[0];
        }
        System.out.println(tmp);

    }

}
