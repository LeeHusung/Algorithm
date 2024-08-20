import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            st.push(str.charAt(i));
            if (st.size() >= 4) {
                if (st.get(st.size() - 1) == 'P' && st.get(st.size() - 2) == 'A'
                        && st.get(st.size() - 3) == 'P' && st.get(st.size() - 4) == 'P') {
                    st.pop();
                    st.pop();
                    st.pop();
                    st.pop();
                    st.push('P');
                }
            }
        }

        if (st.size() == 1 && st.peek() == 'P') {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
