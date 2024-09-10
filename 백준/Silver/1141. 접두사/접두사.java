import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        int[] ch = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String one = arr[i];
            int len = one.length();
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (arr[j].length() < one.length()) continue;
                if (ch[j] == 1) continue;
                if (arr[j].substring(0, len).equals(one)) {
                    ch[i] = 1;
                    break;
                }
            }
        }
        for (int i : ch) {
            if (i == 0) cnt++;
        }
        System.out.println(cnt);

    }
}
