import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int d = Integer.parseInt(s[2]);

        int[][] arr = new int[k][3];
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        long answer = Integer.MAX_VALUE;

        int start = 1;
        int end = n;
        while (start <= end) {
            int middle = (start + end) / 2;
            long cnt = 0;
            for (int[] r : arr) {
                int a = r[0], b = r[1], c = r[2];
                if (middle < a) continue;                // 아직 이 규칙 시작 전
                int last = Math.min(middle, b);          // 중간값 또는 규칙의 끝
                cnt += ( (last - a) / c ) + 1;
            }
            if (cnt >= d) {
                end = middle - 1;
                answer = middle;
            } else {
                start = middle + 1;
            }
        }
        System.out.println(answer);
    }
}
