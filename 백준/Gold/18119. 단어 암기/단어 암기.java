import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] arr = new int[n][26];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][str.charAt(j) - 'a'] = 1;
            }
        }
        int[] ch = new int[n];
        Arrays.fill(ch, 1);
        int[] cnt = new int[n];

        StringBuilder sb = new StringBuilder();

        int ans = n;
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            char x = st.nextToken().charAt(0);
            if (num == 1) {
                for (int j = 0; j < n; j++) {
                    if (arr[j][x - 'a'] == 1) {
                        cnt[j]++;
                        if (ch[j] == 1) {
                            ans--;
                            ch[j] = 0;
                        }
                    }
                }
            } else if (num == 2) {
                for (int j = 0; j < n; j++) {
                    if (ch[j] == 0 && arr[j][x - 'a'] == 1) {
                        cnt[j]--;
                        if (cnt[j] == 0) {
                            ch[j] = 1;
                            ans++;
                        }
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);

    }
}
