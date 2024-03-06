import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String input = br.readLine();

        Stack<Integer> st = new Stack<>();;
        int cnt = 0;
        boolean flag = false;
        for (int i = 0; i < input.length(); i++) {
            while (!st.isEmpty() && !flag && st.peek() < input.charAt(i) - 48) {
                st.pop();
                cnt++;
                if (cnt == m) {
                    flag = true;
                    break;
                }
            }
            st.add(input.charAt(i) - 48);
        }
        StringBuilder sb = new StringBuilder();
        if (cnt < m) {
            for (int i = 0; i < m - cnt; i++) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        System.out.println(sb.reverse());
    }
}
