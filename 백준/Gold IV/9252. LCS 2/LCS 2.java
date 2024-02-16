import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        char[] brr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[arr.length + 1][brr.length + 1];
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < brr.length; j++) {
                if (arr[i] == brr[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    answer = Math.max(dp[i + 1][j + 1], answer);
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                    answer = Math.max(dp[i + 1][j + 1], answer);
                }
            }
        }
//        if (answer == 0) {
//            System.out.println(answer);
//            return;
//        }
        sb.append(answer).append("\n");

        Stack<Character> st = new Stack<>();
        for (int i = arr.length; i > 0; i--) {
            for (int j = brr.length; j > 0; j--) {
                if (dp[i][j] == answer) {
                    if (arr[i-1] == brr[j-1]) {
                        st.add(arr[i - 1]);
                        answer--;
                        break;
                    }
                }
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        System.out.println(sb);
    }
}
