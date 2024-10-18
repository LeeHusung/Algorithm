import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = input.length();
        int idx = 0;

        StringBuilder sb = new StringBuilder();
        while (idx < n) {
            int cnt = 0;
            boolean flag = false;
            while (idx < n && input.charAt(idx) == 'M') {
                cnt++;
                idx++;
            }
            if (idx < n && input.charAt(idx) == 'K') {
                sb.append(5);
                flag = true;
                idx++;
            }
//            if (cnt == 1 && !flag) {
//                sb.append(1);
//            } else {
            if (flag) {
                for (int i = 0; i < cnt; i++) {
                    sb.append(0);
                }
            } else {
                for (int i = 0; i < cnt; i++) {
                    sb.append(1);
                }
            }
//            }
        }
        sb.append("\n");

        idx = 0;
        while (idx < n) {
            int cnt = 0;
            while (idx < n && input.charAt(idx) == 'M') {
                cnt++;
                idx++;
            }
            if (cnt > 1) {
                sb.append(1);
                for (int i = 0; i < cnt - 1; i++) {
                    sb.append(0);
                }
            } else if (cnt == 1) {
                sb.append(1);
            }
            if (idx < n && input.charAt(idx) == 'K') {
                sb.append(5);
                idx++;
            }
        }

        System.out.println(sb);

    }
}
