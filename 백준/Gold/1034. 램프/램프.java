import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
        int max = 0;
        int[] ch = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            if (ch[i] == 0) {
                int cnt = 1;
                String x = list.get(i);
                int zeroCnt = 0;
                for (int j = 0; j < x.length(); j++) {
                    if (x.charAt(j) == '0') zeroCnt++;
                }
                ch[i] = 1;
                if (zeroCnt <= k) {
                    if ((k - zeroCnt) % 2 == 1) continue;
                    else {
                        for (int j = i + 1; j < list.size(); j++) {
                            if (list.get(j).equals(x)) {
                                cnt++;
                                ch[j] = 1;
                            }
                        }
                    }
                } else continue;
                max = Math.max(max, cnt);
            }
        }
        System.out.println(max);
    }
}
