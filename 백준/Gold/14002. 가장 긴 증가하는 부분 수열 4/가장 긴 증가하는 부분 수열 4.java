import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        int answer = 0;
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(s[i - 1]);
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    answer = Math.max(answer, dp[i]);
                }
            }
        }
        System.out.println(answer);

        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int cur = answer;
        for (int i = n; i > 0; i--) {
            if (dp[i] == cur) {
                st.add(arr[i]);
                cur--;
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop()).append(" ");
        }
        System.out.println(sb.toString());
    }
}
