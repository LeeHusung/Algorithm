import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        Integer[] crains = new Integer[n];
        for (int i = 0; i < n; i++) {
            crains[i] = Integer.parseInt(s[i]);
        }
        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> boxes = new ArrayList<>();
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(s1[i]));
        }

        Arrays.sort(crains, (a, b) -> b - a);
        Collections.sort(boxes, Collections.reverseOrder());

        if (boxes.get(0) > crains[0]) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        while(!boxes.isEmpty()) {
            int idx = 0;
            for(int i = 0; i < crains.length;) {
                if(idx == boxes.size()) break;
                else if(crains[i] >= boxes.get(idx)) {
                    boxes.remove(idx);
                    i++;
                }
                else idx++;
            }
            time++;
        }
        System.out.println(time);

    }
}
