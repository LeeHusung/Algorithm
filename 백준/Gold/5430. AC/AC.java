import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String function = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            Deque<String> list = new ArrayDeque<>();
            String[] split = input.substring(1, input.length()-1).split(",");
            if (!input.equals("[]")) {
                for (String s : split) {
                    list.add(s);
                }
            }
            boolean flag = false;
            boolean reverse = false; //안뒤집힘
            for (int j = 0; j < function.length(); j++) {
                if (function.charAt(j) == 'R') {
                    if (reverse) reverse = false;
                    else if (!reverse) reverse = true;
                } else if (function.charAt(j) == 'D') {
                    if (list.size() == 0) {
                        flag = true;
                        break;
                    }

                    if (reverse) {
                        list.pollLast();
                    } else {
                        list.pollFirst();
                    }
                }
            }
            if (flag) {
                ans.append("error").append("\n");
            } else {
                ans.append("[");
                while (!list.isEmpty()) {
                    ans.append(reverse ? list.removeLast() : list.removeFirst());
                    if (!list.isEmpty()) {
                        ans.append(",");
                    }
                }
                ans.append("]").append("\n");
            }
        }

        System.out.println(ans);
    }
}