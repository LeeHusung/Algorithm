import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    static int n, m, len, answer;
    static int[] nums;
    static LinkedList<Integer> list = new LinkedList<>();

    public static void D(int L) {
        if (list.size() >= 1) {
            StringBuilder str = new StringBuilder();
            for (int x : list) {
                str.append(x);
            }
            int parse = Integer.parseInt(str.toString());
            int distance = Math.abs(n - parse);
            answer = Math.min(answer, L + distance);
        }
        if (L < len + 1) {
            for (int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
                D(L + 1);
                list.pollLast();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        answer = Math.abs(n - 100);
        len = String.valueOf(n).length();
        
        boolean[] noWork = new boolean[10];
        if (m > 0) {
            String[] s1 = br.readLine().split(" ");
            for (int i = 0; i < s1.length; i++) {
                noWork[Integer.parseInt(s1[i])] = true;
            }
        }
        
        nums = new int[10 - m];
        int idx = 0;
        for (int i = 0; i < 10; i++) {
            if (!noWork[i]) {
                nums[idx++] = i;
            }
        }

        D(0);
        System.out.println(answer);
    }
}
