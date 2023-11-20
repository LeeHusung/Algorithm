import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        String bomb = sc.next();

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            st.push(input.charAt(i));
            if (st.size() >= bomb.length()) {
                boolean flag = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (bomb.charAt(j) != st.get(st.size() - bomb.length() + j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < bomb.length(); j++) {
                        st.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : st) {
            sb.append(ch);
        }
        if (sb.length() > 0) {
            System.out.println(sb.toString());
        } else System.out.println("FRULA");




//        for (int i = 0; i < input.length(); i++) {
//            String str = "";
//            if (!st.isEmpty() && st.peek().equals(String.valueOf(bomb.charAt(bomb.length() - 1)))) {
//                while (!st.isEmpty() && str.length() != bomb.length()) {
//                    str = st.pop() + str;
//                }
//                if (!str.equals(bomb)) {
//                    st.push(str);
//                }
//            }
//            st.push(String.valueOf(input.charAt(i)));
//        }
//
//        String s = "";
//        while (!st.isEmpty() || s.length() != bomb.length()) {
//            String p = st.pop();
//            s = p + s;
//            if (s.equals(bomb)) break;
//        }
//
//        if (st.isEmpty()) {
//            System.out.println("FRULA");
//        } else {
//            String answer = "";
//            while (!st.isEmpty()) {
//                String k = st.pop();
//                answer = k + answer;
//            }
//            System.out.println(answer);
//        }
    }
}
