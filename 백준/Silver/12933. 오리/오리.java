import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] ch = str.toCharArray();
        int cnt = 0;
        if (str.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }
        int remain = str.length();
        char[] arr = {'q', 'u', 'a', 'c', 'k'};
        while (true) {
            int idx = 0;
            boolean flag = false;
            int[] temp = new int[5];
            int tid = 0;
            for (int i = 0; i < str.length(); i++) {
                if (ch[i] == arr[idx]) {
                    temp[tid++] = i;
                    idx++;
                }
                if (idx == 5) {
                    flag = true;
                    idx = 0;
                    tid = 0;
                    remain -= 5;
                    for (int j = 0; j < 5; j++) {
                        ch[temp[j]] = '.';
                    }
                }
            }
            if (flag) cnt++;
            else {
                System.out.println(-1);
                return;
            }
            if (remain == 0) break;
        }
        System.out.println(cnt);
    }
}
