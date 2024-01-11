import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] mod = new long[(int)m];
        long answer = 0;

        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            long num = Long.parseLong(st.nextToken());
            sum[i] = sum[i - 1] + num;
            if (sum[i] % m == 0) answer++;
            mod[(int)(sum[i] % m)] += 1;
        }


        for (int i = 0; i < m; i++) {
            answer += mod[i] * (mod[i] - 1) / 2;
        }
        System.out.println(answer);

    }
}
