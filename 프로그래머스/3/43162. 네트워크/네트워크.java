import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        int[] ch = new int[n];
        for (int k = 0; k < n; k++) {
            if (ch[k] == 0) {
                ch[k] = 1;
                Queue<Integer> q = new LinkedList<>();
                q.offer(k);
                answer++;
                while (!q.isEmpty()) {
                    int p = q.poll();
                    for (int j = 0; j < n; j++) {
                        int x = computers[p][j];
                        if (x == 1) {
                            if (ch[j] == 0) {
                                ch[j] = 1;
                                 q.offer(j);
                            }
                        }
                    }
                }
            }
        }
   
        return answer;
    }
}