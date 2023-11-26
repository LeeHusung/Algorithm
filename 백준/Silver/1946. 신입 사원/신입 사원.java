import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            for (int j = 0; j < n; j++) {
                String s = br.readLine();
                String[] split = s.split(" ");
                arr[j][0] = Integer.parseInt(split[0]);
                arr[j][1] = Integer.parseInt(split[1]);
            }

            Arrays.sort(arr, (a, b) -> a[0] - b[0]);

            Stack<Integer> st = new Stack<>();
            st.push(arr[0][1]);

            for (int j = 1; j < arr.length; j++) {
                if (arr[j][1] > st.peek()) continue;
                else st.push(arr[j][1]);
            }
            System.out.println(st.size());
            st.clear();
        }
    }
}
