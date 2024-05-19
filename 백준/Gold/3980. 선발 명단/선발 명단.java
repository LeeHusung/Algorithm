import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] ch;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            arr = new int[11][11];
            ch = new int[11];
            answer = 0;
            for (int i = 0; i < 11; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < 11; j++) {
                    arr[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            D(0, 0);

            sb.append(answer).append("\n");

        }
        System.out.println(sb);
    }

    private static void D(int L, int sum) {
        if (L == 11) {
            answer = Math.max(answer, sum);
            return;
        }
        int[] col = arr[L];
        for (int i = 0; i < 11; i++) {
            if (col[i] == 0) continue;
            if (ch[i] == 0) {
                ch[i] = 1;
                D(L + 1, sum += col[i]);
                sum -= col[i];
                ch[i] = 0;
            }
        }
    }
}
