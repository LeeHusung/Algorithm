import java.util.*;
class Solution {
    int count = 0; //최대 탐험 가능한 던전 수
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visited = new boolean[dungeons.length];
        
        //그냥 모두 돌면서, 돌수있는 수가 가장 많으면 그게 답.
        dfs(dungeons, k, 0);
        
        return count;
    }
    
    //던전 도는 모든 경우의 수 반환
    public void dfs(int[][] dungeons, int k, int begin) {
        for (int i = 0; i<dungeons.length; i++) {
            if (!visited[i]){
                if (dungeons[i][0] <= k) {
                    visited[i] = true;
                    dfs(dungeons, k - dungeons[i][1], begin+1);
                    visited[i] = false;
                }
            }
        }
        count = Math.max(count, begin);
    }
}