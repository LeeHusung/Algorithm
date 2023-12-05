import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int n, answer;
    static int[] arr, ch;
    static LinkedList<Integer> list = new LinkedList<>();

    public static void D(int L) {
        if (L == n) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += Math.abs(list.get(i) - list.get(i + 1));
            }
            if (sum < answer) return;
            answer = Math.max(answer, sum);
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    list.add(arr[i]);
                    D(L + 1);
                    ch[i] = 0;
                    list.pollLast();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = 0;
        arr = new int[n];
        ch = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        D(0);
        System.out.println(answer);
    }
}
