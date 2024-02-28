import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static int check(String s, int left, int right, int cnt) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (cnt == 1) return 2;
                int x = check(s, left + 1, right, cnt + 1);
                int y = check(s, left, right - 1, cnt + 1);
                return Math.min(x, y);
            }
            left++;
            right--;
        }
        if (cnt == 1) return 1;
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int left = 0;
            int right = s.length() - 1;
            int cnt = 0;
            int res = check(s, left, right, cnt);
            answer.append(res).append("\n");
        }

        System.out.println(answer);

    }

}
