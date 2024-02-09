import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    static int n, m, k;
    static List<FireBall>[][] arr;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static List<FireBall> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        arr = new ArrayList[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = new ArrayList<>();
            }
        }
        for (int i = 0; i < m; i++) {
            String[] s1 = br.readLine().split(" ");
            int x = Integer.parseInt(s1[0]) - 1;
            int y = Integer.parseInt(s1[1]) - 1;
            int m = Integer.parseInt(s1[2]);
            int s = Integer.parseInt(s1[3]);
            int d = Integer.parseInt(s1[4]);
            list.add(new FireBall(x, y, m, s, d));
        }

        for (int i = 0; i < k; i++) {


            move(n);

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (arr[j][l].size() < 2) {
                        arr[j][l].clear();
                        continue;
                    }
                    int mSum = 0, sSum = 0, oddCount = 0, evenCount = 0;
                    int size = arr[j][l].size();
                    //분열 진행!
                    for(FireBall cur : arr[j][l]){
                        mSum += cur.m;	//질량 더하기
                        sSum += cur.s;	//속도 더하기
                        if(cur.d % 2 == 1)	//방향 홀수일 때
                            oddCount++;
                        else		//방향 짝수일 때
                            evenCount++;
                        list.remove(cur);	//분열될 파이어볼 제거!
                    }
                    arr[j][l].clear();
                    mSum /= 5;	//분열될 질량 구하기
                    if(mSum == 0)	//분열될 질량이 0이면 분열 실패!
                        continue;
                    sSum /= size;	//분열될 속도 구하기
                    //모든 파이어볼 방향이 짝수이거나 홀수일 때
                    if(oddCount == size || evenCount == size){
                        for(int ooo=0;ooo<8;ooo+=2)	//{0, 2, 4, 6} 방향 분열
                            list.add(new FireBall(j,l,mSum, sSum, ooo));
                    }else{
                        for(int ooo=1;ooo<8;ooo+=2)	//{1, 3, 5, 7} 방향 분열
                            list.add(new FireBall(j,l,mSum, sSum, ooo));
                    }
                }
            }
        }

        int answer = 0;
        for (FireBall fb : list) {
            answer += fb.m;
        }
        System.out.println(answer);

    }

    private static boolean check(List<FireBall> fb) {
        List<Boolean> l = new ArrayList<>();
        for (FireBall x : fb) {
            boolean b = check222(x); //홀수면 false
            l.add(b);
        }

        for (int i = 0; i < l.size() - 1; i++) {
            for (int j = i + 1; j < l.size(); j++) {
                if (l.get(i) != l.get(j)) {
                    return false;
                }
            }
        }
        return true;

    }

    private static boolean check222(FireBall fb) {
        if (fb.d % 2 == 1) {
            return false;
        }
        return true;
    }

    private static void move(int n) {
        for (FireBall cur : list) {
            //r, c값 변경
            // +N을 하는 이유는 이동하였을 때 음수가 나올 수 있기 때문입니다.
            int tempR = (cur.r + n + dx[cur.d] * (cur.s%n)) % n;
            int tempC = (cur.c + n + dy[cur.d] * (cur.s%n)) % n;
            cur.r = tempR;
            cur.c = tempC;
            //이동한 파이어볼 저장
            arr[cur.r][cur.c].add(cur);
        }
    }

    static class FireBall {
        int r;
        int c;
        int m;
        int s;
        int d;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
