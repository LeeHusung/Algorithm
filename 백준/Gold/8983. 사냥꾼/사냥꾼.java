import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 사대 수
        int n = Integer.parseInt(st.nextToken()); // 동물 수
        int l = Integer.parseInt(st.nextToken()); // 사정 거리

        int[] shooters = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            shooters[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(shooters); // 사대 위치 정렬

        int count = 0;

        // 동물 위치 입력 및 거리 계산
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int idx = binarySearch(shooters, x); // 가장 가까운 사대 인덱스
            int dist = Integer.MAX_VALUE;

            if (idx >= 0) {
                dist = Math.min(dist, Math.abs(x - shooters[idx]) + y);
            }
            if (idx + 1 < m) {
                dist = Math.min(dist, Math.abs(x - shooters[idx + 1]) + y);
            }

            if (dist <= l) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
