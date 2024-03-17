import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        while(sc.hasNext()) {
            int n = sc.nextInt();
            cnt++;
            sum += n;
            list.add(n);
        }
        Collections.sort(list);
        System.out.println(sum / cnt);
        System.out.println(list.get(cnt/2));
    }
}