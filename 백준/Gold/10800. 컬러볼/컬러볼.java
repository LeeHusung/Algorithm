import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] arr = new long[n][3];
        long cur = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = i + 1;
            arr[i][1] = Long.parseLong(st.nextToken());
            arr[i][2] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr, (a, b) -> (int)a[2] - (int)b[2]);

        long[] res = new long[n + 1];
        long[] sumAsNum = new long[n + 1];

        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < n; i++) {
            while (arr[i][2] > arr[j][2]) {
                sum += arr[j][2];
                sumAsNum[(int) arr[j][1]] += arr[j][2];
                j++;
            }
            res[(int) arr[i][0]] = sum - sumAsNum[(int) arr[i][1]];
        }
        for (int i = 1; i < res.length; i++) {
            sb.append(res[i]).append("\n");
        }
        System.out.println(sb);


    }
}