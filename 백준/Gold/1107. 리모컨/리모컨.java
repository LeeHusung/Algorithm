import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static int n, m, len, answer;
    static int[] nums;
    static LinkedList<Integer> list = new LinkedList<>();

    public static void D(int L) {

        if (list.size() >= 1) {
            String z = "";
            for (int x : list) {
                z += x;
            }
            int num = Integer.parseInt(z);
            int k = Math.abs(n - num);
            int kkk = k + L;
            answer = Math.min(answer, kkk);
        }if (L < len + 1) {
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
        String str2 = String.valueOf(n);
        len = str2.length();
        if (m == 0) {
            nums = new int[10];
            for (int i = 0; i < 10; i++) {
                nums[i] = i;
            }
            D(0);
            System.out.println(answer);
            return;
        }
        if (m > 0) {
            String[] s1 = br.readLine().split(" ");
            List<Integer> noWork = new LinkedList<>();
            for (int i = 0; i < s1.length; i++) {
                noWork.add(Integer.parseInt(s1[i]));
            }
            nums = new int[10 - noWork.size()];
            int idx = 0;
            for (int i = 0; i < 10; i++) {
                if (!noWork.contains(i)) {
                    nums[idx++] = i;
                }
            }
            D(0);
            System.out.println(answer);
        }


    }
}
