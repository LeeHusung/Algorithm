import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[] c = new int[n];
        int[] ch = new int[n];
        int sum = 0;
        int idx = n - 1;
        while (idx > 0) {
            if (sum + idx <= t) {
                sum += idx;
                ch[idx] = 1;
            }
            idx--;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (ch[i] == 1) {
                sb.append(i + 1).append(" ");
            }
        }
        for (int i = 0; i < n; i++) {
            if (ch[i] == 0) {
                sb.append(i + 1).append(" ");
            }
        }
        System.out.println(sb);

    }

}
