import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int[] arr = new int[n];
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s1[i]);
        }

        if (n == 1) {
            System.out.println(Math.abs(arr[0]));
            return;
        }
        Arrays.sort(arr);

        LinkedList<Integer> pre = new LinkedList<>();
        LinkedList<Integer> after = new LinkedList<>();
        LinkedList<Integer> distance = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) pre.add(arr[i]);
            else after.add(arr[i]);
        }
        Collections.sort(pre, Collections.reverseOrder());

        int answer = 0;
//        if (!pre.isEmpty() && !after.isEmpty() && Math.abs(pre.get(pre.size()-1)) >= Math.abs(after.get(after.size() - 1))) {
//            answer += Math.abs(pre.get(pre.size()-1));
//            for (int i = 0; i < m&& !pre.isEmpty(); i++) {
//                pre.remove(pre.size() - 1);
//            }
//        } else if (!after.isEmpty()) {
//            answer += after.get(after.size() - 1);
//            for (int i = 0; i < m&& !after.isEmpty(); i++) {
//                after.remove(after.size() - 1);
//            }
//        }
        while (!after.isEmpty()) {
            distance.add(after.pollLast());
            for (int i = 1; i < m && !after.isEmpty(); i++) {
                after.pollLast();
            }
        }

        while (!pre.isEmpty()) {
            distance.add(-pre.pollLast());
            for (int i = 1; i < m && !pre.isEmpty(); i++) {
                pre.pollLast();
            }
        }
        Collections.sort(distance);
        for (int i=0; i<distance.size(); i++) {
            // 가장 먼 거리만 편도로 이동, 남은 거리는 왕복이라 x2
            if (i == distance.size()-1) answer += distance.get(i);
            else answer += (distance.get(i)*2);
        }
        System.out.println(answer);

    }
}
