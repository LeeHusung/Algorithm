import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            st.push(i + 1);
            sb.append("+");
            while (!st.isEmpty() && st.peek() == arr[idx]) {
                sb.append("-");
                idx++;
                st.pop();
            }
        }

        if (st.isEmpty()) {
            for (int i = 0; i < sb.length(); i++) {
                System.out.println(sb.charAt(i));
            }
        } else System.out.println("NO");

    }
}
