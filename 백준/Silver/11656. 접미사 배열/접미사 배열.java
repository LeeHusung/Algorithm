import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        List<String> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(sb.toString());
            sb.deleteCharAt(0);
        }
        Collections.sort(list);
        for (String str : list) {
            System.out.println(str);
        }


    }
}
