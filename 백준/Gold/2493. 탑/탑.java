import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{arr[0], 0});
        sb.append(0).append(" ");
        for (int i = 1; i < n; i++) {
            if (!stack.isEmpty() && arr[i] > stack.peek()[0]) {
                while (!stack.isEmpty() && stack.peek()[0] < arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    sb.append(0).append(" ");
                    stack.add(new int[]{arr[i], i});
                } else {
                    sb.append(stack.peek()[1] + 1).append(" ");
                    stack.add(new int[]{arr[i], i});
                }
            } else if (!stack.isEmpty() && arr[i] <= stack.peek()[0]) {
                sb.append(stack.peek()[1] + 1).append(" ");
                stack.add(new int[]{arr[i], i});
            }
        }
        System.out.println(sb);
    }
}