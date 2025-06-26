// import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] addedServer = new int[players.length];
        
        for (int i = 0; i < players.length; i++) {
            int x = players[i];
            if (x >= m && addedServer[i] < x / m) {
                int need = x / m;
                int cur = addedServer[i];
                answer += need - cur;
                // System.out.println("need - addedServer[i] : " + (need - addedServer[i]) + ", i : " + i);
                for (int j = i; j < i + k; j++) {
                    if (j < players.length) {
                        addedServer[j] += need - cur;
                    }
                }
            }
        }
        // System.out.println(Arrays.toString(addedServer));
        
        return answer;
    }
}