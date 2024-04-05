import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        if (n == 1) {
            System.out.println(Math.abs(Integer.parseInt(br.readLine())));
            return;
        }

        List<Integer> plus = new ArrayList<>();
        List<Integer> minus = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x > 0) plus.add(x);
            else minus.add(x);
        }

        Collections.sort(plus);
        Collections.sort(minus, (a, b) -> b - a);

        int answer = 0;
        if (minus.isEmpty() && !plus.isEmpty()) {
            int res = plus.get(plus.size() - 1);
            while (!plus.isEmpty()) {
                answer += plus.get(plus.size()-1) * 2;
                for (int i = 0; i < m; i++) {
                    plus.remove(plus.size() - 1);
                    if (plus.isEmpty()) break;
                }
            }
            answer -= res;
        } else if (!minus.isEmpty() && plus.isEmpty()) {
            int res = -minus.get(minus.size() - 1);
            while (!minus.isEmpty()) {
                answer += -minus.get(minus.size()-1) * 2;
                for (int i = 0; i < m; i++) {
                    minus.remove(minus.size() - 1);
                    if (minus.isEmpty()) break;
                }
            }
            answer -= res;
        } else {
            int res = 0;
            if (plus.get(plus.size()-1) > -minus.get(minus.size()-1)) {
                res = plus.get(plus.size()-1);
            } else {
                res = -minus.get(minus.size()-1);
            }
            while (!plus.isEmpty()) {
                answer += plus.get(plus.size() - 1) * 2;
                for (int i = 0; i < m; i++) {
                    plus.remove(plus.size() - 1);
                    if (plus.isEmpty()) break;
                }
            }
            while (!minus.isEmpty()) {
                answer += -minus.get(minus.size() - 1) * 2;
                for (int i = 0; i < m; i++) {
                    minus.remove(minus.size() - 1);
                    if (minus.isEmpty()) break;
                }
            }
            answer -= res;
        }

        System.out.println(answer);

    }
}
