import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                sb.append("1 0").append("\n");
                continue;
            }
            int[] zeroDP = new int[n + 1];
            int[] oneDP = new int[n + 1];

            zeroDP[0] = 1;
            zeroDP[1] = 0;
            for (int j = 2; j < n + 1; j++) {
                zeroDP[j] = zeroDP[j - 1] + zeroDP[j - 2];
            }
            sb.append(zeroDP[n]).append(" ");

            oneDP[0] = 0;
            oneDP[1] = 1;
            for (int j = 2; j < n + 1; j++) {
                oneDP[j] = oneDP[j - 1] + oneDP[j - 2];
            }
            sb.append(oneDP[n]).append("\n");
        }
        System.out.println(sb);
    }
}
