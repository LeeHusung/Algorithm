import java.util.*;

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m, fuel, startRow, startCol;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        fuel = sc.nextInt();

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        startRow = sc.nextInt() - 1;
        startCol = sc.nextInt() - 1;
        ArrayList<int[]> passengers = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int goRow = sc.nextInt() - 1;
            int goCol = sc.nextInt() - 1;
            int arriveRow = sc.nextInt() - 1;
            int arriveCol = sc.nextInt() - 1;
            passengers.add(new int[]{goRow, goCol, arriveRow, arriveCol});
        }

        for (int i = 0; i < m; i++) {
            PriorityQueue<int[]> pq = getShortestDistanceToPassengers(passengers);
            if (pq.isEmpty() || fuel == -1) {
                fuel = -1; //갈 수 있는 손님 없는 경우
                break;
            }
            int[] p = pq.poll();
            if (fuel < p[3]) {
                fuel = -1;
                break;
            }
            fuel -= p[3];

            int[] passenger = passengers.get(p[0]);
            int distanceToArrive = getDistanceToArrive(passenger);
            if (fuel < distanceToArrive || distanceToArrive == -1) {
                fuel = -1;
                break;
            }
            fuel -= distanceToArrive;
            startRow = passenger[2];
            startCol = passenger[3];
            passengers.remove(p[0]);

            fuel += distanceToArrive * 2;
        }
        System.out.println(fuel);

    }

    private static PriorityQueue<int[]> getShortestDistanceToPassengers(ArrayList<int[]> passengers) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[3] == b[3] ? (a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]) : a[3] - b[3]);

        Queue<int[]> q = new LinkedList<>();
        int[][] ch = new int[n][n];
        q.offer(new int[]{startRow, startCol, 0});
        ch[startRow][startCol] = 1;
//
//        // 시작점에 손님이 있는지 확인
//        for (int i = 0; i < passengers.size(); i++) {
//            int[] passenger = passengers.get(i);
//            if (passenger[0] == startRow && passenger[1] == startCol) {
//                pq.offer(new int[]{i, passenger[0], passenger[1], 0});
//            }
//        }
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (fuel < p[2]) { //최단거리 손님 찾으러 가는데 연료가 부족한 경우
                break;
            }
            for (int i = 0; i < passengers.size(); i++) {
                int[] passenger = passengers.get(i);
                if (passenger[0] == p[0] && passenger[1] == p[1]) {
                    pq.offer(new int[]{i, passenger[0], passenger[1], p[2]});
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] != 1 && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    q.offer(new int[]{nx, ny, p[2] + 1});
                }
            }
        }
        return pq;
    }

    private static int getDistanceToArrive(int[] passenger) {
        Queue<int[]> q = new LinkedList<>();
        int[][] ch = new int[n][n];
        q.offer(new int[]{passenger[0], passenger[1], 0});
        ch[passenger[0]][passenger[1]] = 1;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (fuel < p[2]) { //손님 태우러 가는데 연료 부족
                return -1;
            }
            if (p[0] == passenger[2] && p[1] == passenger[3]) return p[2];
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && arr[nx][ny] != 1 && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    q.offer(new int[]{nx, ny, p[2] + 1});
                }
            }
        }
        return -1;
    }
}
