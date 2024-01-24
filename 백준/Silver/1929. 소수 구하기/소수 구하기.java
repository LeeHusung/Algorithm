import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);

        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            boolean flag = true;
            if (i < 2) flag = false;
            else if (i == 2) flag = true;
            else {
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
