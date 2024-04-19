import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] check = new int[n];
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                check[i] = Integer.parseInt(s[i]);
            }
            int m = Integer.parseInt(br.readLine());
            int[] answer = new int[m];
            String[] s1 = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                answer[i] = Integer.parseInt(s1[i]);
            }
            Arrays.sort(check);

            for (int i = 0; i < answer.length; i++) {
                boolean ch = binary_search(check, answer[i]);
                if (ch) {
                    sb.append(1).append("\n");
                } else sb.append(0).append("\n");
            }

        }
        System.out.println(sb);
    }

    private static boolean binary_search(int[] check, int num) {
        int start = 0;
        int end = check.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (check[middle] > num) {
                end = middle - 1;
            } else if (check[middle] < num) {
                start = middle + 1;
            } else return true;
        }
        return false;
    }
}
