import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 1;
        while (true) {
            int answer = 0;
            String input = br.readLine();
            if (input.charAt(0) == '-') break;
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                if (!st.isEmpty() && input.charAt(i) == '}') {
                    if (st.peek() == '{') {
                        st.pop();
                        continue;
                    }
                }
                if (!st.isEmpty() && input.charAt(i) == '{') {
                    st.push('{');
                }
                if (st.isEmpty() && input.charAt(i) == '{') {
                    st.push(input.charAt(i));
                }
                else if (st.isEmpty() && input.charAt(i) == '}') {
                    answer++;
                    st.push('{');
                }
            }
            if (!st.isEmpty()) answer += st.size()/ 2;
            System.out.println(cnt + ". " + answer);
            cnt++;
        }
    }
}
