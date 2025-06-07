import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static List<Knight>[][] list;
    static int[][] arr;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static List<Knight> knights = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);
        list = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list[i][j] = new ArrayList<>();
            }
        }
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            Knight knight = new Knight(x, y, d, i + 1);
            knights.add(knight);
            list[x][y].add(knight);
        }
        int turn = 0;

        while (true) {
            turn++;
            if (turn > 1000) {
                System.out.println(-1);
                return;
            }
            for (Knight knight : knights) {
                boolean isFourFloor = move(knight);
                if (isFourFloor) {
                    System.out.println(turn);
                    return;
                }
            }
//            System.out.println("========knights==========");
//            System.out.println(knights);
//            System.out.println();
//            System.out.println("===================");
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(list[i][j] + " ");
//                }
//                System.out.println();
//            }
        }


    }

    private static boolean move(Knight knight) {
        int dir = knight.d;
        int nx = knight.x + dx[dir];
        int ny = knight.y + dy[dir];
        int num = knight.num;
        //이동하려는 칸이 파란색인 경우
        if (nx >= n || ny >= n || nx < 0 || ny < 0 || arr[nx][ny] == 2) {
            //방향 반대로 하기
            if (knight.d == 0) knight.d = 1;
            else if (knight.d == 1) knight.d = 0;
            else if (knight.d == 2) {
                knight.d = 3;
            }
            else if (knight.d == 3) knight.d = 2;
            nx = knight.x + dx[knight.d];
            ny = knight.y + dy[knight.d];
            //방향 바꾼 후 이동하려는 칸이 파란색이거나 범위 벗어나면 가만히 있는다.
            if (nx >= n || ny >= n || nx < 0 || ny < 0 || arr[nx][ny] == 2) {
                return false;
            }
            //흰색이거나 빨간색이면 한 칸 이동한다.

            boolean flag = false;
            List<Knight> temp = new ArrayList<>();
            for (Knight knight1 : list[knight.x][knight.y]) {
                if (knight1.num == num) {
                    flag = true;
                }
                if (flag) {
                    temp.add(knight1);
                }
            }
//            System.out.println("temp: " + temp);
            list[knight.x][knight.y].removeAll(temp);
            list[nx][ny].addAll(temp);
            for (Knight knight1 : temp) {
                knight1.x = nx;
                knight1.y = ny;
            }
            if (list[nx][ny].size() >= 4) return true;
//                System.out.println("===================");
//                for (int i = 0; i < n; i++) {
//                    for (int j = 0; j < n; j++) {
//                        System.out.print(list[i][j] + " ");
//                    }
//                    System.out.println();
//                }
        }

        //이동하려는 칸이 빨간색인 경우
        if (arr[nx][ny] == 1) {
            boolean flag = false;
            List<Knight> temp = new ArrayList<>();
            for (Knight knight1 : list[knight.x][knight.y]) {
                if (knight1.num == num) {
                    flag = true;
                }
                if (flag) {
                    temp.add(knight1);
                }
            }
            list[knight.x][knight.y].removeAll(temp);
            for (int i = temp.size() - 1; i >= 0; i--) {
                list[nx][ny].add(temp.get(i));
            }
//            list[nx][ny].addAll(temp.reversed());
            for (Knight knight1 : temp) {
                knight1.x = nx;
                knight1.y = ny;
            }
            if (list[nx][ny].size() >= 4) return true;
        }

        //이동하려는 칸이 흰색인 경우
        if (arr[nx][ny] == 0) {
            boolean flag = false;
            List<Knight> temp = new ArrayList<>();
            for (Knight knight1 : list[knight.x][knight.y]) {
                if (knight1.num == num) {
                    flag = true;
                }
                if (flag) {
                    temp.add(knight1);
                }
            }
            list[knight.x][knight.y].removeAll(temp);
            list[nx][ny].addAll(temp);
//            System.out.println("temp: " + temp);
            for (Knight knight1 : temp) {
                knight1.x = nx;
                knight1.y = ny;
            }
//            System.out.println("===================");
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(list[i][j] + " ");
//                }
//                System.out.println();
//            }
            if (list[nx][ny].size() >= 4) return true;

        }

        return false;
    }

    static class Knight {
        int x;
        int y;
        int d;
        int num;

        public Knight(int x, int y, int d, int num) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.num = num;
        }

        @Override
        public boolean equals(Object object) {
            if (object == null || getClass() != object.getClass()) return false;
            Knight knight = (Knight) object;
            return x == knight.x && y == knight.y && d == knight.d && num == knight.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, d, num);
        }

        @Override
        public String toString() {
            return "Knight{" +
                    "x=" + x +
                    ", y=" + y +
                    ", d=" + d +
                    ", num=" + num +
                    '}';
        }
    }
}
