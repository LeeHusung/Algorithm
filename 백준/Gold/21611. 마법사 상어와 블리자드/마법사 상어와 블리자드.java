import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] goosl;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int one = 0, two = 0, three = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        goosl = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                goosl[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int d = Integer.parseInt(s1[0]);
            int s = Integer.parseInt(s1[1]);
            startBlizard(d, s);
        }

        System.out.println((1 * one) + (2 * two) + (3 * three));
    }

    private static void startBlizard(int d, int s) {
        int sharkX = (n + 1) / 2;
        int sharkY = (n + 1) / 2;
        //얼음 파편 던져 구슬 모두 파괴
        switch (d) {
            case 1 :
                for (int i = 0; i < s; i++) {
                    sharkX--;
                    goosl[sharkX][sharkY] = 0;
                }
                break;
            case 2 :
                for (int i = 0; i < s; i++) {
                    sharkX++;
                    goosl[sharkX][sharkY] = 0;
                }
                break;
            case 3 :
                for (int i = 0; i < s; i++) {
                    sharkY--;
                    goosl[sharkX][sharkY] = 0;
                }
                break;
            case 4 :
                for (int i = 0; i < s; i++) {
                    sharkY++;
                    goosl[sharkX][sharkY] = 0;
                }
                break;
        }
        List<Integer> destroyedGoosl = collectLinkedList();
        //폭발
        while (true) {
            if (!explode(destroyedGoosl)) break;
        };

        //변화하는 단계
        List<Integer> changedList = change(destroyedGoosl);

        setGooslList(changedList);
    }

    private static List<Integer> change(List<Integer> destroyedGoosl) {
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < destroyedGoosl.size(); i++) {
            int cnt = 1;
            Integer x = destroyedGoosl.get(i);
            for (int j = i + 1; j < destroyedGoosl.size(); j++) {
                if (x == destroyedGoosl.get(j)) {
                    cnt++;
                } else break;
            }
            int a = cnt;
            int b = x;
            i += cnt - 1;
            if (newList.size() >= n * n - 1) break;
            newList.add(a);
            if (newList.size() >= n * n - 1) break;
            newList.add(b);
        }
        return newList;
    }

    private static boolean explode(List<Integer> destroyedGoosl) {
        List<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < destroyedGoosl.size() - 1; i++) {
            Integer x = destroyedGoosl.get(i);
            int cnt = 1;
            int lastJ = 0;
            for (int j = i + 1; j < destroyedGoosl.size(); j++) {
                if (x != 0 && x == destroyedGoosl.get(j)) {
                    cnt++;
                    lastJ = j;
                } else break;
            }
            if (cnt >= 4) {
                tmp.add(new int[]{i, lastJ, x});
                if (destroyedGoosl.get(i) == 1) one += (lastJ - i + 1);
                if (destroyedGoosl.get(i) == 2) two += (lastJ - i + 1);
                if (destroyedGoosl.get(i) == 3) three += (lastJ - i + 1);
                for (int j = i; j <= lastJ; j++) {
                    destroyedGoosl.set(j, 0);
                }
                i += cnt - 1;
            }
        }
        for (int i = 0; i < destroyedGoosl.size(); i++) {
            if (destroyedGoosl.get(i) == 0) {
                destroyedGoosl.remove(i);
                i--;
            }
        }
        return !tmp.isEmpty();
    }

    private static List<Integer> collectLinkedList() {
        List<Integer> list = new ArrayList<>();
        int sharkX = (n + 1) / 2;
        int sharkY = (n + 1) / 2;
        int dir = 0;
        int cnt = 0;
        int change = 1;
        while (sharkX >= 1 && sharkY >= 1 && sharkX <= n && sharkY <= n) {
            for (int i = 0; i < change; i++) {
                sharkX += dx[dir];
                sharkY += dy[dir];
                if (goosl[sharkX][sharkY] == 0) continue;
                list.add(goosl[sharkX][sharkY]);
            }
            dir = (dir + 1) % 4;
            cnt++;
            if (cnt % 2 == 0) change++;
        }
        return list;
    }

    private static void setGooslList(List<Integer> list) {
        int[][] newGoosl = new int[n + 1][n + 1];
        int sharkX = (n + 1) / 2;
        int sharkY = (n + 1) / 2;
        int idx = 0;
        int dir = 0;
        int cnt = 0;
        int change = 1;
        while (idx < list.size() && sharkX >= 1 && sharkY >= 1 && sharkX <= n && sharkY <= n) {
            for (int i = 0; i < change; i++) {
                sharkX += dx[dir];
                sharkY += dy[dir];
                newGoosl[sharkX][sharkY] = list.get(idx++);
                if (idx >= list.size()) break;
            }
            dir = (dir + 1) % 4;
            cnt++;
            if (cnt % 2 == 0) change++;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                goosl[i][j] = newGoosl[i][j];
            }
        }

    }
//
//    private static void print(int[][] arr) {
//        System.out.println("===================");
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
}
