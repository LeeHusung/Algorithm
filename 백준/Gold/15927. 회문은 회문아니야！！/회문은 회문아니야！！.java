import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = input.length();

        int ch = -1;
        boolean flag = false;
        for (int i = 0; i < n - 1; i++) {
            if (input.charAt(i) != input.charAt(i + 1)) {
                flag = true;
                break;
            }
        }
        for (int i = 0; i < n / 2; i++) {
            if (input.charAt(i) != input.charAt(n - i - 1)) {
                ch = 1;
                break;
            }
        }

        //입력이 회문인 경우
        if (ch == -1 && flag) {
            System.out.println(n - 1);
        }
        //입력이 회문인데 모든 숫자가 같은 경우
        else if (ch == -1 && !flag) {
            System.out.println(-1);
        }
        //입력이 회문이 아닌 경우
        else if (ch == 1) {
            System.out.println(n);
        }
    }
}
