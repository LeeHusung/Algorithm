import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] arr = str.split("");
        if (arr.length % 2 == 1) {
            System.out.println(0);
            return;
        }
        Stack<String> st = new Stack<>();
        int answer = 0;
        int tmp = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("(")) {
                tmp *= 2;
                st.push("(");
            } else if (arr[i].equals("[")) {
                tmp *= 3;
                st.push("[");
            } else if (arr[i].equals(")")) {
                if (st.isEmpty() || !st.peek().equals("(")) {
                    answer = 0;
                    break;
                }
                if (arr[i - 1].equals("(")) {
                    answer += tmp;
                }
                st.pop();
                tmp /= 2;
            } else if (arr[i].equals("]")) {
                if (st.isEmpty() || !st.peek().equals("[")) {
                    answer = 0;
                    break;
                }
                if (arr[i - 1].equals("[")) {
                    answer += tmp;
                }
                st.pop();
                tmp /= 3;
            }
        }

        System.out.println(answer);
    }
}
