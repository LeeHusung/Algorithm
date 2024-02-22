import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> friend = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> wonsu = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            friend.add(new ArrayList<>());
            wonsu.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[1]);
            int y = Integer.parseInt(s[2]);
            if (s[0].equals("F")) {
                friend.get(x).add(y);
                friend.get(y).add(x);
            } else {
                wonsu.get(x).add(y);
                wonsu.get(y).add(x);
            }
        }

        for (ArrayList<Integer> list : wonsu) {
            if (list.size() >= 2) {
                for (int i = 0; i < list.size()-1; i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        friend.get(list.get(i)).add(list.get(j));
                        friend.get(list.get(j)).add(list.get(i));
                    }
                }
            }
        }
        int[] ch = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                answer++;
                q.offer(i);
                while (!q.isEmpty()) {
                    Integer p = q.poll();
                    for (int x : friend.get(p)) {
                        if (ch[x] == 0) {
                            ch[x] = 1;
                            q.offer(x);
                        }
                    }
                }
            }
        }
        System.out.println(answer);

    }
}
