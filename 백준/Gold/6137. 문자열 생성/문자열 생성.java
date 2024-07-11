import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int n;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        int x = 0;
        int y = n - 1;
        while (x <= y) {
            if (list.get(x).charAt(0) < list.get(y).charAt(0)) {
                sb.append(list.get(x++));
            } else if (list.get(x).charAt(0) > list.get(y).charAt(0)) {
                sb.append(list.get(y--));
            } else {
                int x1 = x + 1;
                int y1 = y - 1;
                int size = sb.length();
                while (x1 <= y1) {
                    if (list.get(x1).charAt(0) < list.get(y1).charAt(0)) {
                        sb.append(list.get(x++));
                        break;
                    } else if (list.get(x1).charAt(0) > list.get(y1).charAt(0)) {
                        sb.append(list.get(y--));
                        break;
                    } else {
                        x1++;
                        y1--;
                    }
                }
                if (size == sb.length()) {
                    sb.append(list.get(x++));
                }
            }
        }
        for (int i=0;i<sb.length();i++) {
            if (i!=0 && i%80==0) System.out.println(); // 80글자마다 새줄 문자 출력
            System.out.print(sb.charAt(i));
        }

    }
}
