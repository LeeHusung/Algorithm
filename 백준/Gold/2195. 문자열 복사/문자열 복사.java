import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();
        int x = 0;
        int y = 0;
        int cnt = 0;
        while (true) {
            char goal = p.charAt(y);
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == goal) {
                    int cur = 1;
                    int k = y + 1;
                    for (int j = i + 1; j < s.length(); j++) {
                        if (k < p.length() && s.charAt(j) == p.charAt(k)) {
//                            System.out.println("j: " + j);
                            cur++;
                            k++;
                            max = Math.max(max, cur);
                        } else {
                            max = Math.max(max, cur);
                            break;
                        }
                    }
                    max = Math.max(max, cur);
//                    System.out.println(cur + " " + max);
//                    max = Math.max(max, cur);
                }
            }
            cnt++;
//            if (cnt > 50) break;
            y += max;
//            System.out.println("y:" + y);
            if (y > p.length() - 1) break;
//            System.out.println(y);
        }
        System.out.println(cnt);
    }
}
