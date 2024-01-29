import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        H = Integer.parseInt(s[1]);
        int[] down = new int[N/2];
        int[] up = new int[N/2];
        int aidx = 0, bidx = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                down[aidx++] = Integer.parseInt(br.readLine());
            } else up[bidx++] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(down);
        Arrays.sort(up);

        int answer = Integer.MAX_VALUE;
        int cnt = 1;
        for (int i = 1; i < H + 1; i++) {
            int downCnt = calcul(0, N / 2, down, i);
            int upCnt = calcul(0, N / 2, up, H - i + 1);
            if (downCnt + upCnt < answer) {
                answer = downCnt + upCnt;
                cnt = 1;
            } else if (downCnt + upCnt == answer) {
                cnt++;
            }
        }
        System.out.println(answer + " " + cnt);
    }

    private static int calcul(int left, int right, int[] arr, int target) {
        while (left < right) {
            int middle = (left + right) / 2;
            if (arr[middle] >= target) right = middle;
            else left = middle + 1;
        }
        return arr.length-right;
    }
}
