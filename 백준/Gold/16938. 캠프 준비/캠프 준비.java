import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R, X, answer;
    static int[] arr, ch;
    static LinkedList<Integer> list = new LinkedList<>();

    private static void D(int now, int start) {
        if (list.size() >= 2) {
            long sum = 0;
            for (Integer x : list) {
                sum += arr[x];
            }
            if (sum > R) return;
            if (Math.abs(arr[list.get(0)] - arr[list.get(list.size() - 1)]) >= X) {
                if (sum >= L && sum <= R) {
                    answer++;
                }
            }
        }

        if (now == N) return;
        for (int i = start; i < N; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                list.add(i);
                D(now + 1, i + 1);
                list.pollLast();
                ch[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        L = Integer.parseInt(s[1]);
        R = Integer.parseInt(s[2]);
        X = Integer.parseInt(s[3]);
        arr = new int[N];
        ch = new int[N];
        answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        D(0, 0);

        System.out.println(answer);
    }
}
