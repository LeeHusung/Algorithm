import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    //1874

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            while (!st.isEmpty() && st.peek() == arr[idx]) {
                st.pop();
                sb.append("-").append("\n");
                idx++;
                continue;
            }
            st.push(i);
            sb.append("+").append("\n");

        }
        if (!st.isEmpty()) {
            while (idx < n && arr[idx] == st.peek()) {
                sb.append("-").append("\n");
                st.pop();
                idx++;
            }
        }
        if (!st.isEmpty()) {
            System.out.println("NO");
        } else System.out.println(sb);
    }
}
