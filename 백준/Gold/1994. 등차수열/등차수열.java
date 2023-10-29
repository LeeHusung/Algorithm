import java.util.*;

public class Main {

    public int solution(int[] nums, int n) {
        if (n == 1) return 1;
        int[][] dy = new int[n+1][n+1];
        int answer = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                dy[i][j] = 2;
                int pre = 2 * nums[i] - nums[j];
                int k = 0;
                for (k = i - 1; k >= 1 ; k--) {
                    if (nums[k] == pre) break;
                }
                dy[i][j] = Math.max(dy[i][j], dy[k][i] + 1);
                answer = Math.max(answer, dy[i][j]);

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n+1];
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        System.out.println(T.solution(nums, n));
    }

}
