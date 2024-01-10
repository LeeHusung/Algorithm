import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        char[] list = s.toCharArray();
//        LinkedList<Character> list = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(s.charAt(i));
//        }

        boolean flag = false;
        int answer = 0;
        int cnt = Integer.MAX_VALUE;
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] == 'B') {
                flag = true;
                continue;
            }
            if (list[i] == 'R' && flag) {
                answer++;
            }
        }
        cnt = Math.min(answer, cnt);
        flag = false;
        answer = 0;
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] == 'R') {
                flag = true;
                continue;
            }
            if (list[i] == 'B' && flag) {
                answer++;
            }
        }
        cnt = Math.min(answer, cnt);

        flag = false;
        answer = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 'R') {
                flag = true;
                continue;
            }
            if (list[i] == 'B' && flag) {
                answer++;
            }
        }
        cnt = Math.min(answer, cnt);

        flag = false;
        answer = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == 'B') {
                flag = true;
                continue;
            }
            if (list[i] == 'R' && flag) {
                answer++;
            }
        }
        cnt = Math.min(answer, cnt);
        System.out.println(cnt);


    }
}
