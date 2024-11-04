import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (len1 != 0 && len2 != 0) {
            if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
                sb.append(str1.charAt(len1 - 1));
                len1--;
                len2--;
            } else {
                if (dp[len1][len2 - 1] < dp[len1 - 1][len2]) {
                    len1--;
                } else len2--;
            }
        }
        System.out.println(sb.reverse());
    }
}
