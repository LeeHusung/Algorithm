import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int n, s, answer;
    static int[] arr;
    static LinkedList<Integer> list = new LinkedList<>();

    public static void D(int start) {
        int sum = 0;
        for (int x : list) {
            sum += x;
        }
        if (!list.isEmpty() && sum == s) answer++;
        for (int i = start; i < arr.length; i++) {
                list.add(arr[i]);
                D(i + 1);
                list.pollLast();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] z = br.readLine().split(" ");
        n = Integer.parseInt(z[0]);
        s = Integer.parseInt(z[1]);
        answer = 0;
        arr = new int[n];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }
        D(0);
        System.out.println(answer);
    }
}
