import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if (str.charAt(str.length() - 1) == ':' && str.charAt(str.length() - 2) == ':') {
            String[] split = str.split(":");
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for (String s : split) {
//                System.out.print(s + " ");
                if (!s.isEmpty()) {
                    cnt++;
                    while (s.length() != 4) {
                        s = "0" + s;
                    }
                    sb.append(s).append(":");
                }
            }
            String z = "";
            for (int i = 0; i < 8 - cnt; i++) {
                z += "0000:";
            }
            sb.append(z);
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);

        }
        else {
            String[] split = str.split(":");
            StringBuilder sb = new StringBuilder();
            int cnt = 0;
            for (String s : split) {
                if (!s.isEmpty()) {
                    cnt++;
                    while (s.length() != 4) {
                        s = "0" + s;
                    }
                    sb.append(s).append(":");
                } else
                    sb.append("A");
            }
            String z = "";
            for (int i = 0; i < 8 - cnt; i++) {
                z += "0000:";
            }
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == 'A') {
                    sb.insert(i, z);
                    break;
                }
            }
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == 'A') {
                    sb.deleteCharAt(i);
                    i--;
                }
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }
    }
}
