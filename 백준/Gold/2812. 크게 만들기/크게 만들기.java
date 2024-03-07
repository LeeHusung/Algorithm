import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        String input = br.readLine();

        Deque<Integer> st = new ArrayDeque<>();;
        int cnt = 0;
        boolean flag = false;
        for (int i = 0; i < input.length(); i++) {
            while (!st.isEmpty() && !flag && st.peekFirst() < input.charAt(i) - 48) {
                st.pollFirst();
                cnt++;
                if (cnt == m) {
                    flag = true;
                    break;
                }
            }
            st.addFirst(input.charAt(i) - 48);
        }
        StringBuilder sb = new StringBuilder();
        if (cnt < m) {
            for (int i = 0; i < m - cnt; i++) {
                if (!st.isEmpty()) {
                    st.pollFirst();
                }
            }
        }
        while (!st.isEmpty()) {
            sb.append(st.pollLast());
        }
        System.out.println(sb);
    }
}
