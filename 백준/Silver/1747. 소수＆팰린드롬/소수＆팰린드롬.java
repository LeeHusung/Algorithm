import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = n; i <= 1003001; i++) {
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

            boolean flag2 = true;
            if (flag) {
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                for (int j = 0; j < sb.length() / 2; j++) {
                    if (sb.charAt(j) != sb.charAt(sb.length()-j - 1)) {
                        flag2 = false;
                        break;
                    }
                }
            }
            if (flag && flag2) {
                System.out.println(i);
                return;
            }
        }
    }
}
