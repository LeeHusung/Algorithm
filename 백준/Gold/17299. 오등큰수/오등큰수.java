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
        int[] res = new int[n];
        int[] cnt = new int[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[arr[i]]++;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && cnt[arr[stack.peek()]] < cnt[arr[i]]) {
                res[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }

        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);

    }
}
