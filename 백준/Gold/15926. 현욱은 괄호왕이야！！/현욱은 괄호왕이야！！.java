import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        Stack<Integer> st = new Stack<>();
        st.add(-1);

        int max = 0;
        for (int i = 0; i < input.length(); i++) {
            char p = input.charAt(i);
            if (p == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty()) {
                    st.add(i);
                } else {
                    max = Math.max(max, i - st.peek());
                }
            }
        }

        System.out.println(max);

    }
}
