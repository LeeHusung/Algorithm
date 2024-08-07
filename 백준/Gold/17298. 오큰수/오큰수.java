import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer str = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                arr[st.peek()] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            Integer idx = st.pop();
            arr[idx] = -1;
        }
        for (int x : arr) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }
}
