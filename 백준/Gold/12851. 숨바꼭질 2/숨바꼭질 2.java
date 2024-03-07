import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int end = Integer.parseInt(s[1]);
        int[] ch = new int[100001];
        LinkedList<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        ch[start] = 1;
        if (start == end) {
            System.out.println(0);
            System.out.println(1);
            return;
        }
        int cnt = 0;
        int res = 0;
        boolean flag = false;
        while (!q.isEmpty()) {
            int len = q.size();
//            System.out.println("len : " + len);
            for (int i = 0; i < len; i++) {
                int[] p = q.poll();
//                System.out.println("p[0] : " + p[0]);
                if (p[0] == end) {
                    cnt++;
                    res = p[1];
                    flag = true;
                }
                int nx = p[0] + 1;
                int ny = p[0] - 1;
                int nz = p[0] * 2;
                if (nx >= 0 && nx <= 100000 && ch[nx] == 0) {
                    q.offer(new int[]{nx, p[1] + 1});
                }
                if (ny >= 0 && ny <= 100000 && ch[ny] == 0) {
                    q.offer(new int[]{ny, p[1] + 1});
                }
                if (nz >= 0 && nz <= 100000 && ch[nz] == 0) {
                    q.offer(new int[]{nz, p[1] + 1});
                }
            }
            if (flag) break;
            for (int i = 0; i < q.size(); i++) {
                ch[q.get(i)[0]] = 1;
            }
        }
        System.out.println(res);
        System.out.println(cnt);
    }
}