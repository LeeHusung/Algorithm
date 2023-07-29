import java.util.*;
class Solution {
    
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[][] visited = new int[maps.length][maps[0].length];
        
        bfs(maps, visited);
        answer = visited[maps.length-1][maps[0].length-1];
        
        if (answer == 0) {
            answer = -1;
        }
        
        return answer;
    }
    
    public void bfs(int[][] maps, int[][] visited) {
        int x = 0;
        int y = 0;
        visited[x][y] = 1;
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{x, y});
        
        while (!q.isEmpty()) {
            int[] current = q.remove();
            int cx = current[0];
            int cy = current[1];
            
            for (int i = 0; i<4; i++) {
                int bx = cx + dx[i];
                int by = cy + dy[i];
                
                if (bx < 0 || bx > maps.length-1 || by < 0 || by > maps[0].length-1) {
                    continue;
                }
                
                if (visited[bx][by] == 0 && maps[bx][by] == 1) {
                    visited[bx][by] = visited[cx][cy] + 1;
                    q.add(new int[]{bx, by});
                }
            }
        }
        
        
    }
}