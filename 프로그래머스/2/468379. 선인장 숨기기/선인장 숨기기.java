import java.util.*;
class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[] answer = new int[2];
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(arr[i], 1_000_000);
        }
        for (int i = 0; i < drops.length; i++) {
            arr[drops[i][0]][drops[i][1]] = i + 1;
        }
        int[][] slidings = new int[m][n];
        for (int i = 0; i < m; i++) {
            int[] res = sliding(arr[i], w);
            slidings[i] = res;
        }
        for (int i = 0; i < n - w + 1; i++) {
            int[] res = slidingVertical(slidings, i, h);
            for (int j = 0; j < res.length; j++) {
                slidings[j][i] = res[j];
            }
        }
        
        int max = 0;
        for (int i = 0; i < m - h + 1; i++) {
            for (int j = 0; j < n - w + 1; j++) {
                if (slidings[i][j] == 1_000_000) {
                    return new int[]{i, j};
                }
                if (slidings[i][j] > max) {
                    max = slidings[i][j];
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        
        return answer;
    }
    
    public int[] sliding(int[] tmp, int w) {
        int[] res = new int[tmp.length - w + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < tmp.length; i++) {
            while (!q.isEmpty() && i - q.peekFirst() >= w) {
                q.pollFirst();
            }
            while (!q.isEmpty() && tmp[q.peekLast()] >= tmp[i]) {
                q.pollLast();
            }
            q.offerLast(i);
            if (i - w  + 1 >= 0) {
                res[i - w + 1] = tmp[q.peekFirst()];
            }
        }
        return res;
    }
    
    public int[] slidingVertical(int[][] slidings, int col, int h) {
        int[] res = new int[slidings.length - h + 1];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < slidings.length; i++) {
            while (!q.isEmpty() && i - q.peekFirst() >= h) {
                q.pollFirst();
            }
            while (!q.isEmpty() && slidings[q.peekLast()][col] >= slidings[i][col]) {
                q.pollLast();
            }
            q.offerLast(i);
            if (i - h + 1 >= 0) {
                res[i - h + 1] = slidings[q.peekFirst()][col];
            }
        }
        return res;
    }
}