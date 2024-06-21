import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, max, min;
    static List<Integer> arr = new ArrayList<>();
    static List<Integer> clone = new ArrayList<>();
    static int[] cal = new int[4];
    static int[] res, ch;
    static List<Integer> list = new ArrayList<>();

    private static void D(int L) {
        if (L == n - 1) {
            int x = calculate(res);
            max = Math.max(max, x);
            min = Math.min(min, x);
            arr.clear();
            arr.addAll(clone);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                res[L] = list.get(i);
                D(L + 1);
                ch[i] = 0;
                res[L] = 0;
            }
        }
    }

    private static int calculate(int[] res) {
        List<Integer> tempArr = new ArrayList<>(arr);
        List<Integer> tempOps = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            tempOps.add(res[i]);
        }

        for (int i = 0; i < tempOps.size(); i++) {
            if (tempOps.get(i) == 3 || tempOps.get(i) == 4) {
                if (tempOps.get(i) == 3) {
                    int result = tempArr.get(i) * tempArr.get(i + 1);
                    tempArr.set(i, result);
                    tempArr.remove(i + 1);
                } else if (tempOps.get(i) == 4) {
                    int result = tempArr.get(i) / tempArr.get(i + 1);
                    tempArr.set(i, result);
                    tempArr.remove(i + 1);
                }
                tempOps.remove(i);
                i--; 
            }
        }

        int sum = tempArr.get(0);
        int idx = 1;
        for (int i = 0; i < tempOps.size(); i++) {
            if (tempOps.get(i) == 1) {
                sum += tempArr.get(idx);
            } else if (tempOps.get(i) == 2) {
                sum -= tempArr.get(idx);
            }
            idx++;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        res = new int[n - 1];
        ch = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        clone.addAll(arr);
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(s[i]);
        }
        for (int i = 0; i < cal.length; i++) {
            if (cal[i] > 0) {
                for (int j = 0; j < cal[i]; j++) {
                    list.add(i + 1);
                }
            }
        }

        D(0);
        System.out.println(max);
        System.out.println(min);
    }
}
